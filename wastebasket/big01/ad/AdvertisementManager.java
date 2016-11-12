package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

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

        class VideoSet implements Comparable<VideoSet>
        {
            int duration = 0;
            long price = 0;
            List<Advertisement> videos;

            public VideoSet(List<Advertisement> videos)
            {
                this.videos = videos;
                for (Advertisement video : this.videos)
                {
                    duration += video.getDuration();
                    price += video.getAmountPerOneDisplaying();
                }
            }

            @Override
            public int compareTo(VideoSet o)
            {
                int result = Long.compare(o.price, this.price);
                result = result == 0 ? Long.compare(o.duration, this.duration) : result;
                return result == 0 ? Long.compare(this.videos.size(), o.videos.size()) : result;
            }

            void sortVideos()
            {
                Collections.sort(this.videos, new Comparator<Advertisement>()
                {
                    @Override
                    public int compare(Advertisement o1, Advertisement o2)
                    {
                        int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                        result = result == 0 ? Long.compare(o1.getAmountPerOneDisplaying()* 1000 / o1.getDuration(), o2.getAmountPerOneDisplaying()* 1000 / o2.getDuration()) : result;
                        return result;
                    }
                });
            }
        }

        List<VideoSet> videoSets = new ArrayList<>();

        for (Advertisement adv : storage.list())
        {
            if (adv.getHits() > 0
                    && adv.getDuration() <= timeSeconds)
            {
                List<Advertisement> list = new ArrayList<>();
                list.add(adv);
                videoSets.add(new VideoSet(getList(list, timeSeconds-adv.getDuration())));
            }
        }
        if (videoSets.isEmpty()) throw new NoVideoAvailableException();
        Collections.sort(videoSets);
        videoSets.get(0).sortVideos();

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(videoSets.get(0).videos,videoSets.get(0).price,videoSets.get(0).duration));


        for (Advertisement video : videoSets.get(0).videos)
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

    private List<Advertisement> getList(List<Advertisement> added, int duration)
    {
        if (duration == 0) return added;

        for (Advertisement video : storage.list())
        {
            if (video.getHits() > 0
                    && video.getDuration() <= duration
                    && !added.contains(video))
            {
                added.add(video);
                getList(added, duration - video.getDuration());
                break;
            }
        }
        return added;
    }

}
