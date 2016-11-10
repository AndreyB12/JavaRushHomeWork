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
        videos.add(new Advertisement(someContent, "First Video", 13, 2, 10 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 40, 3, 13 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 20, 3, 10 * 60));  //10 min
        videos.add(new Advertisement(someContent, "Video #4", 20, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #5", 22, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #6", 20, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #7", 25, 2, 45));  //11 min
        videos.add(new Advertisement(someContent, "Video #8", 20, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #9", 20, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #10", 20, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #11", 26, 1, 1 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #12", 20, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #13", 20, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #14", 20, 1, 1 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #15", 20, 1, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #16", 20, 1, 30));  //11 min
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
