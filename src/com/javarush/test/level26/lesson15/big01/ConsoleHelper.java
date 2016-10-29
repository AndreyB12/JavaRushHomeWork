package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by butkoav on 11.10.2016.
 */
public class ConsoleHelper
{
    static ResourceBundle commonRes = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.common", Locale.ENGLISH);
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
        if (result.toLowerCase().equals("exit")) throw new InterruptOperationException();

        return result;
    }

    public static String askCurrencyCode(String errorMessage) throws InterruptOperationException
    {
        writeMessage(commonRes.getString("choose.currency.code"));
        while (true)
        {
            String code = readString();

            if (code.matches("[a-zA-Z]{3}"))
                return code.toUpperCase();
            writeMessage(errorMessage);
        }
    }

    public static String[] getValidTwoDigits(String code) throws InterruptOperationException
    {
        writeMessage(String.format(commonRes.getString("choose.denomination.and.count.format"), code));
        String string;
        while (true)
        {
            string = readString();
            if (string.matches("^\\d+ \\d+$")) return string.split(" ");
            writeMessage(commonRes.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        Operation operation = null;

        while (true)
        {
            writeMessage(commonRes.getString("choose.operation"));
            try
            {
                writeMessage(String.format("1 - %s, 2 - %s, 3 - %s, 4 - %s"
                        , commonRes.getString("operation.INFO")
                        , commonRes.getString("operation.DEPOSIT")
                        , commonRes.getString("operation.WITHDRAW")
                        , commonRes.getString("operation.EXIT")
                ));
                operation = Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
                break;
            }
            catch (Exception e)
            {
                writeMessage(commonRes.getString("invalid.data"));
            }
        }
        return operation;
    }

    public static void sayGoodbye()
    {
        writeMessage(commonRes.getString("the.end"));
    }

    public static boolean askAreYouSure() throws InterruptOperationException
    {
        writeMessage("Are you sure? <y,n>");
        String s = readString();
        return (s.matches("[yY]")) ? true : false;
    }
}
