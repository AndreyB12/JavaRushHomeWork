package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

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

    public Map<Date, Double> getDayAdvProfit()
    {
        Map<Date, Double> dayStatistic = new TreeMap<>(Collections.reverseOrder());
        Date date;
        Double amount;
        for (EventDataRow event_ : statisticStorage.getEvents(EventType.SELECTED_VIDEOS))
        {
            VideoSelectedEventDataRow event = (VideoSelectedEventDataRow) event_;
            date = getMidnight(event.getDate());
            amount = ((double) event.getAmount()) / 100;
            if (dayStatistic.containsKey(date)) dayStatistic.put(date, dayStatistic.get(date) + amount);
            else dayStatistic.put(date, amount);
        }

        return dayStatistic;
    }

    public Map<Date, Map<String, Integer>> getCookDayStatistic()
    {
        Map<Date, Map<String, Integer>> dayStatistic = new TreeMap<>(Collections.reverseOrder());
        Date date;
        Integer time;
        String name;
        Map<String, Integer> cookTimes;
        for (EventDataRow event_ : statisticStorage.getEvents(EventType.COOKED_ORDER))
        {
            CookedOrderEventDataRow event = (CookedOrderEventDataRow) event_;

            date = getMidnight(event.getDate());
            name = event.getCookName();
            time = event.getTime();

            if (dayStatistic.containsKey(date))
            {
                cookTimes = dayStatistic.get(date);
                if (cookTimes.containsKey(name)) cookTimes.put(name, cookTimes.get(name) + time);
                else cookTimes.put(name, time);
            } else
            {
                cookTimes = new TreeMap<>();
                cookTimes.put(name, time);
                dayStatistic.put(date, cookTimes);
            }
        }

        return dayStatistic;
    }

    private Date getMidnight(Date date)
    {
        // today
        Calendar date_ = new GregorianCalendar();
        date_.setTime(date);
        // reset hour, minutes, seconds and millis
        date_.set(Calendar.HOUR_OF_DAY, 0);
        date_.set(Calendar.MINUTE, 0);
        date_.set(Calendar.SECOND, 0);
        date_.set(Calendar.MILLISECOND, 0);
        return date_.getTime();
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
