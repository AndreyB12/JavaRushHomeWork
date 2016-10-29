package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by butkoav on 19.10.2016.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.info", Locale.ENGLISH);
    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean hasMoney = false;
        for (CurrencyManipulator currency : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (currency.hasMoney())
            {
                hasMoney = true;
                ConsoleHelper.writeMessage(String.format("%s - %d", currency.getCurrencyCode(), currency.getTotalAmount()));
            }
        }
        if (!hasMoney) ConsoleHelper.writeMessage(res.getString("no.money"));
    }

    InfoCommand()
    {
    }
}
