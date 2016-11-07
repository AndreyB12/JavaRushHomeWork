package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

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
        //Remove not displayed videos
        List<Advertisement> tmpStorage = new ArrayList<>();
        for (Advertisement video : storage.list())
        {
            if (video.getHits() > 0 && video) tmpStorage.add(video);
        }
        Collections.sort(tmpStorage, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return Integer.compare(o1.getDuration(), o2.getDuration());
            }
        });


        List<Advertisement> videoToView = new ArrayList<>();
        long[][] costMatrix = new long[tmpStorage.size() + 1][timeSeconds + 1];
        fillCostMatrix(tmpStorage.size() - 1, timeSeconds, tmpStorage, costMatrix);
        addToResult(tmpStorage.size(), timeSeconds, costMatrix, videoToView, tmpStorage);

        if (videoToView.isEmpty()) throw new NoVideoAvailableException();
        Collections.sort(videoToView, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                if (result == 0)
                    result = Long.compare(o1.getAmountPerOneDisplaying()
                            / o1.getDuration(), o2.getAmountPerOneDisplaying() / o2.getDuration());
                return result;
            }
        });
        for (Advertisement video : videoToView)
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
