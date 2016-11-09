package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.util.Map;

/**
 * Created by butkoav on 09.11.2016.
 */
public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        Double summ = 0d;
        for (Map.Entry<String, Double> entry : StatisticManager.getInstance().getDayAdvProfit().entrySet())
        {
            summ += entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", entry.getKey(),entry.getValue()));
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f",summ));
    }

    public void printCookWorkloading()
    {
    }

    public void printActiveVideoSet()
    {
    }

    public void printArchivedVideoSet()
    {
    }

}
