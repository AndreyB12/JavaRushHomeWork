package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by butkoav on 11.10.2016.
 */
public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String result = "";
        try
        {
            result = reader.readLine();
        }
        catch (IOException e)
        {
        }
        if(result.toLowerCase().equals("exit")) throw new InterruptOperationException();

        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage("Enter currency code (3 letters):");
        while (true)
        {
            String code = readString();
            if (code.matches("[a-zA-Z]{3}"))
                return code.toUpperCase();
            writeMessage("Wrong currency code. Try again!");
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage("Input two positive integers separeted by space (\"200 99\"):");
        String string;
        while (true)
        {
            string = readString();
            if (string.matches("^\\d+ \\d+$")) return string.split(" ");
            writeMessage("Wrong input. Try again!");
        }
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        Operation operation = null;

        while (true)
        {
            writeMessage("Select command (1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT):");
            try
            {
                operation = Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
                break;
            }
            catch (Exception e)
            {
                writeMessage("Wrong command. Try again!");
            }
        }
        return operation;
    }

    public static void sayGoodbye()
    {
        writeMessage("Arrivederci!");
    }

    public static boolean askAreYouSure() throws InterruptOperationException
    {
        writeMessage("Are you sure? <y,n>");
        String s = readString();
        return (s.matches("[yY]")) ? true : false;
    }
}
