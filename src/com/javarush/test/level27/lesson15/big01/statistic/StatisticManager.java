package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by butkoav on 08.11.2016.
 */
public class StatisticManager
{
    private final static StatisticManager statisticManager = new StatisticManager();
    private final StatisticStorage statisticStorage = new StatisticStorage();
    private final Set<Cook> cooks = new HashSet<>();

    private StatisticManager()
    {
    }

    public static StatisticManager getInstance()
    {
        return statisticManager;
    }

    public void register(Cook cook)
    {
        cooks.add(cook);
    }

    public void register(EventDataRow data)
    {
        statisticStorage.put(data);
    }

    public Map<String, Double> getDayAdvProfit()
    {
        Map<String, Double> dayProfit = new TreeMap<>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-YYYY",Locale.ENGLISH);
        String day;
        Double amount;
        for (EventDataRow event_ : statisticStorage.getEvents(EventType.SELECTED_VIDEOS))
        {
            VideoSelectedEventDataRow event = (VideoSelectedEventDataRow) event_;
            day = format.format(event.getDate());
            amount =  ((double) event.getAmount()) / 100;
            if (dayProfit.containsKey(day)) dayProfit.put(day, dayProfit.get(day) + amount);
            else dayProfit.put(day, amount);
        }
        return dayProfit;
    }


    private static class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage()
        {
            this.storage = new HashMap<>();
            for (int i = 0; i < EventType.values().length; i++)
            {
                storage.put(EventType.values()[i], new ArrayList<EventDataRow>());
            }
        }

        public Map<EventType, List<EventDataRow>> getStorage()
        {
            return storage;
        }

        private void put(EventDataRow data)
        {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> getEvents(EventType et)
        {
            return storage.get(et);
        }
    }
}
