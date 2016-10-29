package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by butkoav on 29.10.2016.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException
    {
        while (true)
        {
            String cID;
            String cPIN;
            ConsoleHelper.writeMessage("Enter card number (12 nums):");
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
            if (!validCreditCards.containsKey(cID))
            {
                ConsoleHelper.writeMessage("Wrong CardID");
                continue;
            }
            if (!validCreditCards.getString(cID).equals(cPIN))
            {
                ConsoleHelper.writeMessage("Wrong Pin");
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
