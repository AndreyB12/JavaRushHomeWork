package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by butkoav on 11.10.2016.
 */
public class CashMachine
{
    public static void main(String... args)
    {

        try
        {
            Locale.setDefault(Locale.ENGLISH);
            Operation operation = null;
            CommandExecutor.execute(Operation.LOGIN);
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (operation!=Operation.EXIT);
        }
        catch (InterruptOperationException e)
        {
            ConsoleHelper.sayGoodbye();

        }
    }
}
