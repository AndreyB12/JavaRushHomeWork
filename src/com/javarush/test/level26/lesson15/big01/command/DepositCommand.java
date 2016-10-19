package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by butkoav on 19.10.2016.
 */
class DepositCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String code = ConsoleHelper.askCurrencyCode();
        String[] denoms = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code).addAmount(Integer.valueOf(denoms[0]), Integer.valueOf(denoms[1]));
    }

    DepositCommand()
    {
    }
}
