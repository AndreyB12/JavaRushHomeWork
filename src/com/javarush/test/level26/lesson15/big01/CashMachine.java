package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

/**
 * Created by butkoav on 11.10.2016.
 */
public class CashMachine
{
    public static void main(String... args)
    {
        Locale.setDefault(Locale.ENGLISH);
        String code = ConsoleHelper.askCurrencyCode();
        String[] denoms = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code).addAmount(Integer.valueOf(denoms[0]),Integer.valueOf(denoms[1]));
    }
}
