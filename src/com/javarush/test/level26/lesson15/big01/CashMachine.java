package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

import java.util.Locale;

/**
 * Created by butkoav on 11.10.2016.
 */
public class CashMachine
{
    public static void main(String... args)
    {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation = null;
        do
        {

            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        }
        while (operation != Operation.EXIT);
    }
}
