package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by butkoav on 19.10.2016.
 */
class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        while (true)
        {
            try
            {
                ConsoleHelper.writeMessage("Please enter expected amount:");
                int amount = Integer.parseInt(ConsoleHelper.readString());

                if (!cm.isAmountAvailable(amount)){
                    ConsoleHelper.writeMessage("Not enough money!");
                    continue;
                }
                Map<Integer, Integer> cash = cm.withdrawAmount(amount);
                List<Integer> denoms = new ArrayList<>(cash.keySet());
                Collections.sort(denoms, new Comparator<Integer>()
                {
                    @Override
                    public int compare(Integer o1, Integer o2)
                    {
                        return -o1.compareTo(o2);
                    }
                });
                for (int denom : denoms)
                {
                    ConsoleHelper.writeMessage(String.format("\t%d - %d", denom, cash.get(denom)));
                }
                ConsoleHelper.writeMessage("Transaction successful!");
                break;
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(e.getMessage());
            }
            catch (Exception e)
            {
                ConsoleHelper.writeMessage(e.getMessage());
                ConsoleHelper.writeMessage("Please try again!");
            }
        }
    }

    WithdrawCommand()
    {
    }
}
