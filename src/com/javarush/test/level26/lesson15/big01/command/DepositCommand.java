package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by butkoav on 19.10.2016.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.deposit");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        String[] denoms = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code).addAmount(Integer.valueOf(denoms[0]), Integer.valueOf(denoms[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.valueOf(denoms[0]) * Integer.valueOf(denoms[1]), code));
    }

    DepositCommand()
    {
    }
}
