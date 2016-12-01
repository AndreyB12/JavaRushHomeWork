package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by butkoav on 30.11.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String... args) throws IOException
    {
        ConsoleHelper.writeMessage("Input port number for Server Socket:");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(port);
        ConsoleHelper.writeMessage(String.format("Server started, port = %d", port));

        try
        {
            while (true)
            {
                new Handler(serverSocket.accept()).start();
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage("Error occured:");
            ConsoleHelper.writeMessage(e.getMessage());
        }
        finally
        {
            serverSocket.close();
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet())
        {
            try
            {
                entry.getValue().send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Error occurred:");
                ConsoleHelper.writeMessage(e.getMessage());
            }
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            ConsoleHelper.writeMessage("New connection established. Address = " + socket.getRemoteSocketAddress());
            String clientName = null;
            try (Connection connection = new Connection(socket))
            {
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage(e.getMessage());
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage(e.getMessage());
            }

            if (clientName != null && !clientName.isEmpty())
            {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }
            ConsoleHelper.writeMessage(String.format("Connection with Address = %s closed!", socket.getRemoteSocketAddress()));
        }

        private String serverHandshake(Connection connection) throws IOException,
                ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer != null && answer.getType() == MessageType.USER_NAME)
                {
                    String userName = answer.getData();
                    if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName))
                    {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return userName;
                    }
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws
                IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData())));
                } else
                {
                    ConsoleHelper.writeMessage("Wrong type of message!");
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws
                IOException
        {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet())
            {
                if (!userName.equals(entry.getKey()))
                {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }
    }
}
