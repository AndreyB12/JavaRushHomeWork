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
        List<VideoToView> lists = new ArrayList<>();
        for (Advertisement video : storage.list())
        {
            if (video.getDuration() <= timeSeconds
                    && video.getHits() > 0)
            {
                List<Advertisement> chosen = new ArrayList<>();
                chosen.add(video);
                getListToView(chosen, timeSeconds - video.getDuration());
                lists.add(new VideoToView(chosen));
            }

        }
        Collections.sort(lists);

        List<Advertisement> list = lists.get(0).list;

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

    private void getListToView(List<Advertisement> chosenVideos, int timeSeconds)
    {

        for (Advertisement video : storage.list())
        {
            if (!chosenVideos.contains(video)
                    && video.getDuration() <= timeSeconds
                    && video.getHits() > 0)
            {
                chosenVideos.add(video);
                getListToView(chosenVideos, timeSeconds - video.getDuration());
                return;
            }
        }

    }

    private class VideoToView implements Comparable<VideoToView>
    {
        int moneySumm = 0;
        int duration = 0;
        List<Advertisement> list = new ArrayList<>();

        VideoToView(List<Advertisement> list)
        {
            this.list = list;
            for (Advertisement video : list)
            {
                moneySumm += video.getAmountPerOneDisplaying();
                duration += video.getDuration();
            }
        }

        @Override
        public int compareTo(VideoToView o)
        {
            return Integer.compare(o.moneySumm, this.moneySumm) * 100
                    + Integer.compare(o.duration, this.duration) * 10
                    + Integer.compare(this.list.size(), o.list.size());
        }
    }

}
