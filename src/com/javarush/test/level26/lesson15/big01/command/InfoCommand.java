package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by butkoav on 19.10.2016.
 */
class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        boolean hasMoney = false;
        for (CurrencyManipulator currency : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (currency.hasMoney())
            {
                hasMoney = true;
                System.out.println(String.format("%s - %d", currency.getCurrencyCode(), currency.getTotalAmount()));
            }
        }
        if (!hasMoney) System.out.println("No money available.");
    }

    InfoCommand()
    {
    }
}
