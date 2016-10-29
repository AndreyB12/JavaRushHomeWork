package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by butkoav on 29.10.2016.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.login", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String cID;
        String cPIN;
        ConsoleHelper.writeMessage(res.getString("specify.data"));

        while (true)
        {
            cID = ConsoleHelper.readString();
            cPIN = ConsoleHelper.readString();
            if (!cID.matches("^[0-9]{12}$") || !cPIN.matches("^[0-9]{4}$"))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (validCreditCards.containsKey(cID))
            {
                if (validCreditCards.getString(cID).equals(cPIN))
                {
                    break;
                }
            }
            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cID));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cID));
    }

    LoginCommand()
    {
    }
}
