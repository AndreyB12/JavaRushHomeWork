package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;

/**
 * Created by butkoav on 08.11.2016.
 */
public class StatisticManager
{
    private final static StatisticManager statisticManager = new StatisticManager();

    private StatisticManager()
    {
    }

    public static StatisticManager getStatisticManager()
    {
        return statisticManager;
    }

    public void register(EventDataRow data)
    {
        //TODO
    }
}
