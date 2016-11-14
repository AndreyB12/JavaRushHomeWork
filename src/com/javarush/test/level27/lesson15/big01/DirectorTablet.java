package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by butkoav on 09.11.2016.
 */
public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        String day;
        double summ = 0;
        for (Map.Entry<Date, Double> entry : StatisticEventManager.getInstance().getAdvertisementStatistic().entrySet())
        {
            day = format.format(entry.getKey());
            summ += entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", day, entry.getValue()));
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", summ));
        ConsoleHelper.writeMessage("");

    }

    public void printCookWorkloading()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY");
        String day;
        int time;
        for (Map.Entry<Date, Map<String, Integer>> entry : StatisticEventManager.getInstance().getCookStatistic().entrySet())
        {
            day = format.format(entry.getKey());
            ConsoleHelper.writeMessage(day);
            for (Map.Entry<String, Integer> cook : entry.getValue().entrySet())
            {
                time = (cook.getValue() + 59) / 60;

                ConsoleHelper.writeMessage(String.format("%s - %d min", cook.getKey(), time));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet()
    {
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getActiveVideoSet();

        Collections.sort(list, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement adv : list)
            ConsoleHelper.writeMessage(String.format("%s - %d", adv.getName(), adv.getHits()));
    }

    public void printArchivedVideoSet()
    {
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getArchivedVideoSet();

        Collections.sort(list, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement adv : list)
            ConsoleHelper.writeMessage(adv.getName());
    }

}
