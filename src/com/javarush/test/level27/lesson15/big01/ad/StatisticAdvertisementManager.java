package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by butkoav on 13.11.2016.
 */
public class StatisticAdvertisementManager
{
    private final static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private final AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager()
    {
    }

    public static StatisticAdvertisementManager getInstance()
    {
        return instance;
    }

    public List<Advertisement> getActiveVideoSet()
    {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement adv : advertisementStorage.list())
        {
            if (adv.getHits() > 0)
            {
                list.add(adv);
            }
        }
        return list;
    }

    public List<Advertisement> getArchivedVideoSet()
    {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement adv : advertisementStorage.list())
        {
            if (adv.getHits() == 0)
            {
                list.add(adv);
            }
        }
        return list;
    }
}
