package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by butkoav on 05.11.2016.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        List<Advertisement> list = new ArrayList<>();
        list.addAll(storage.list());
        if (list.isEmpty()) throw new NoVideoAvailableException();
        Collections.sort(list, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying()) * 10;
                result += Long.compare(o1.getAmountPerOneDisplaying() / o1.getDuration(), o2.getAmountPerOneDisplaying() / o2.getDuration());
                return result;
            }
        });
        for (Advertisement video : list)
        {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %s, %s"
                    , video.getName()
                    , video.getAmountPerOneDisplaying()
                    , video.getAmountPerOneDisplaying() * 1000 / video.getDuration()));
            try
            {
                video.revalidate();
            }
            catch (UnsupportedOperationException e)
            {
            }
        }
    }
}
