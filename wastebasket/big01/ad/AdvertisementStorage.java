package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by butkoav on 05.11.2016.
 */
class AdvertisementStorage
{
    private final static AdvertisementStorage advertisementStorage = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage()
    {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "Video #1",20 , 1, 4 * 60)); // 2 min
        videos.add(new Advertisement(someContent, "Video #2", 5, 2, 13 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Video #3", 15, 2, 23 * 60));  //10 min
      /*  videos.add(new Advertisement(someContent, "Video #4", 10, 2, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #5", 10, 2, 3 * 60));  //11 min
*/
    }

    public List<Advertisement> list()
    {
        return videos;
    }

    public void add(Advertisement advertisement)
    {
        videos.add(advertisement);
    }

    public static AdvertisementStorage getInstance()
    {
        return advertisementStorage;
    }
}
