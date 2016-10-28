package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by butkoav on 29.10.2016.
 */
public class LoginCommand implements Command
{
    private static final long cardID = 123456789012L;
    private static final int pin = 1234;

    @Override
    public void execute() throws InterruptOperationException
    {
        while (true)
        {
            String cID;
            String cPIN;
            ConsoleHelper.writeMessage("Enter card number (12 nums) and a pin(4 nums):");
            cID = ConsoleHelper.readString();
            if (!cID.matches("^[0-9]{12}$"))
            {
                ConsoleHelper.writeMessage("Data not valid!");
                continue;
            }
            ConsoleHelper.writeMessage("Enter a pin(4 nums):");
            cPIN = ConsoleHelper.readString();
            if (!cPIN.matches("^[0-9]{4}$"))
            {
                ConsoleHelper.writeMessage("Data not valid!");
                continue;
            }
            if (!(Long.valueOf(cID) == cardID && Integer.valueOf(cPIN) == pin))
            {
                ConsoleHelper.writeMessage("Wrong CardID or PIN");
                continue;
            }
            ConsoleHelper.writeMessage("Welcome!");
            break;
        }
    }

    LoginCommand()
    {
    }
}
