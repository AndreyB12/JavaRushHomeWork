package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by butkoav on 09.11.2016.
 */
public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        String day;
        Double summ = 0d;
        for (Map.Entry<Date, Double> entry : StatisticManager.getInstance().getDayAdvProfit().entrySet())
        {
            day = format.format(entry.getKey());
            summ += entry.getValue();
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", day, entry.getValue()));
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", summ));
     //   ConsoleHelper.writeMessage("");

    }

    public void printCookWorkloading()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        String day;
        int time;
        for (Map.Entry<Date, Map<String, Integer>> entry : StatisticManager.getInstance().getCookDayStatistic().entrySet())
        {
            day = format.format(entry.getKey());
            ConsoleHelper.writeMessage(day);
            for (Map.Entry<String, Integer> cook : entry.getValue().entrySet())
            {
                time = cook.getValue();
                if (time == 0) continue;
                time = time % 60 == 0 ? time / 60 : time / 60 + 1;
                ConsoleHelper.writeMessage(String.format("%s - %d min", cook.getKey(), time));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet()
    {
    }

    public void printArchivedVideoSet()
    {
    }

}
