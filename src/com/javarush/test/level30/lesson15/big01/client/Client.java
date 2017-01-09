package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by butkoav on 02.12.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String... args)
    {
        Client client = new Client();
        client.run();

    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Error occurred:");
            ConsoleHelper.writeMessage(e.getMessage());
            return;
        }
        if (clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while (clientConnected)
        {
            String text = ConsoleHelper.readString();
            if (text.equalsIgnoreCase("exit")) break;
            if (shouldSentTextFromConsole()) sendTextMessage(text);
        }
    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Enter server address:");
        //TODO Реализовать проверку адреса сервера. Может быть IP или localhost
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Enter server port:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Enter your name:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Error occurred:");
            ConsoleHelper.writeMessage(e.getMessage());
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread
    {
//        Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь
//        его. Его реализация с учетом уже созданных методов выглядит очень просто. Давай
//        напишем ее:
//            17.1.	Запроси адрес и порт сервера с помощью методов getServerAddress() и
//        getServerPort().
//            17.2.	Создай новый объект класса java.net.Socket, используя данные, полученные в
//        п.17.1.
//            17.3.	Создай объект класса Connection, используя сокет из п.17.2.
//            17.4.	Вызови метод, реализующий "рукопожатие" клиента с сервером
//            (clientHandshake()).
//            17.5.	Вызови метод, реализующий основной цикл обработки сообщений сервера.
//17.6.	При возникновении исключений IOException или ClassNotFoundException
//        сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false
//        в качестве параметра.
        public void run()
        {
            try
            {
                Socket socket = new Socket(getServerAddress(),getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }

        //16.2.	Добавь защищенный метод void clientMainLoop() throws IOException,
        //            ClassNotFoundException. Этот метод будет реализовывать главный цикл обработки
        //        сообщений сервера. Внутри метода:
        //16.2.1.	Получи сообщение от сервера, используя соединение connection.
        //16.2.2.	Если это текстовое сообщение (тип TEXT), обработай его с помощью метода
        //        processIncomingMessage().
        //16.2.3.	Если это сообщение с типом USER_ADDED, обработай его с помощью метода
        //        informAboutAddingNewUser().
        //16.2.4.	Если это сообщение с типом USER_REMOVED, обработай его с помощью метода
        //        informAboutDeletingNewUser().
        //16.2.5.	Если клиент получил сообщение какого-либо другого типа, кинь исключение
        //        IOException("Unexpected MessageType").
        //16.2.6.	Размести код из пунктов 16.2.1 – 16.2.5 внутри бесконечного цикла. Цикл будет
        //        завершен автоматически если произойдет ошибка (будет кинуто исключение) или
        //        поток, в котором работает цикл, будет прерван.
        protected void clientMainLoop() throws IOException,
                ClassNotFoundException
        {
            Message message;
            while (true)
            {
                message = connection.receive();
                switch (message.getType())
                {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        //16.1.	Добавь защищенный метод clientHandshake() throws IOException,
        //  ClassNotFoundException. Этот метод будет представлять клиента серверу. Он должен:
        //16.1.1.	В цикле получать сообщения, используя соединение connection
        //16.1.2.	Если тип полученного сообщения NAME_REQUEST (сервер запросил имя),
        //  запросить ввод имени пользователя с помощью метода getUserName(), создать
        //  новое сообщение с типом USER_NAME и введенным именем, отправить
        //  сообщение серверу.
        //16.1.3.	Если тип полученного сообщения NAME_ACCEPTED (сервер принял имя), значит
        //  сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого
        //  очень ждет. Сделай это с помощью метода notifyConnectionStatusChanged(),
        //  передав в него true. После этого выйди из метода.
        //16.1.4.	Если пришло сообщение с каким-либо другим типом, кинь исключение
        //  IOException("Unexpected MessageType").
        protected void clientHandshake() throws IOException,
                ClassNotFoundException
        {
            while (true)
            {
                Message incMessage = connection.receive();
                if (incMessage.getType() == MessageType.NAME_REQUEST)
                {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (incMessage.getType() == MessageType.NAME_ACCEPTED)
                {
                    notifyConnectionStatusChanged(true);
                    return;
                } else
                {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("User %s has joined the chat.", userName));
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("User %s has left the chat.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }
    }
}
