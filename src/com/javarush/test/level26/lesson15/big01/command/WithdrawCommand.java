package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
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
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"withdraw");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        while (true)
        {
            try
            {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                int amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0) throw new Exception();
                if (!cm.isAmountAvailable(amount))
                {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
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
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, code));
                break;
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
            catch (Exception e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }

    WithdrawCommand()
    {
    }
}
