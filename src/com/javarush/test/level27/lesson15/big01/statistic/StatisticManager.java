package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

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
    }
}
