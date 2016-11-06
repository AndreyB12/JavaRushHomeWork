package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

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
        List<Advertisement> tmpStorage = new ArrayList<>();
        for (Advertisement video : storage.list())
        {
            if (video.getHits() > 0) tmpStorage.add(video);
        }
        Collections.sort(tmpStorage, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return Integer.compare(o1.getDuration(),o2.getDuration());
            }
        });


         List<Advertisement> videoToView = new ArrayList<>();
        long[][] costMatrix = new long[tmpStorage.size() + 1][timeSeconds + 1];
        fillCostMatrix(tmpStorage.size() - 1, timeSeconds,tmpStorage,costMatrix);
        addToResult(tmpStorage.size(), timeSeconds,costMatrix,videoToView,tmpStorage);

        if (videoToView.isEmpty()) throw new NoVideoAvailableException();
        Collections.sort(videoToView, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying()) * 10;
                result += Long.compare(o1.getAmountPerOneDisplaying() / o1.getDuration(), o2.getAmountPerOneDisplaying() / o2.getDuration());
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

    private long fillCostMatrix(int videoNumb, int timeCapacity, List<Advertisement> tmpStorage,long[][] costMatrix)
    {
        if (videoNumb < 0 || timeCapacity <= 0) return 0;
        long withVideo = 0;

        if (tmpStorage.get(videoNumb).getDuration() <= timeCapacity)
        {
            withVideo = tmpStorage.get(videoNumb).getAmountPerOneDisplaying()
                    + fillCostMatrix(videoNumb - 1, timeCapacity - tmpStorage.get(videoNumb).getDuration(),tmpStorage,costMatrix);

        }
        long withoutVideo = fillCostMatrix(videoNumb - 1, timeCapacity,tmpStorage,costMatrix);
        if (withVideo > withoutVideo)
        {
            costMatrix[videoNumb + 1][timeCapacity] = withVideo;
            return withVideo;
        } else
        {

            costMatrix[videoNumb + 1][timeCapacity] = withoutVideo;
            return withoutVideo;
        }
    }
    private void addToResult(int numb, int capacity,long[][] costMatrix,List<Advertisement> videoToView,List<Advertisement> tmpStorage)
    {
        if (numb <= 0 || capacity <= 0) return;
        if (costMatrix[numb][capacity] == costMatrix[numb - 1][capacity])
        {
            addToResult(numb - 1, capacity, costMatrix,videoToView,tmpStorage);
        } else
        {
            videoToView.add(tmpStorage.get(numb - 1));
            addToResult(numb - 1, capacity - tmpStorage.get(numb - 1).getDuration(), costMatrix, videoToView,tmpStorage);
        }
    }

}
