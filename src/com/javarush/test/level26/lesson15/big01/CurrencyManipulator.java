package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

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
}
