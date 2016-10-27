package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by butkoav on 12.10.2016.
 */
public class CurrencyManipulator
{
    String currencyCode;
    Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denominations, int count)
    {
        if (this.denominations.containsKey(denominations))
            this.denominations.put(denominations, this.denominations.get(denominations) + count);
        else this.denominations.put(denominations, count);
    }

    public int getTotalAmount()
    {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            result += entry.getKey() * entry.getValue();
        }
        return result;
    }

    public boolean hasMoney()
    {
        return (denominations.size() != 0) ? true : false;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return (getTotalAmount() >= expectedAmount) ? true : false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> map = new HashMap<>();
        if (expectedAmount == 0) return map;
        List<Integer> denoms = new ArrayList<>(denominations.keySet());
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
            int count = expectedAmount / denom;
            if (count == 0) continue;
            for (int i = count; i > 0; i--)
            {
                if (i > denominations.get(denom)) continue;
                try
                {
                    denominations.put(denom, denominations.get(denom) - i);
                    map.putAll(withdrawAmount(expectedAmount - i * denom));
                    map.put(denom, i);
                    return map;
                }
                catch (NotEnoughMoneyException e)
                {
                    denominations.put(denom, denominations.get(denom) + i);
                }

            }
        }
        throw new NotEnoughMoneyException();
    }
}
