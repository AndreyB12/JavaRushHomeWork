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
        add(new Advertisement(someContent, "Первое1", 152, 3, 3 * 60));
        add(new Advertisement(someContent, "Второе2", 5, 0, 5 * 60));
        add(new Advertisement(someContent, "aa3", 3, 0, 3 * 60));
        add(new Advertisement(someContent, "bb4", 99, 10, 2 * 60));
        add(new Advertisement(someContent, "X", 2000, 3, 6 * 60));
        add(new Advertisement(someContent, "AA5", 150, 3, 3 * 60));
        add(new Advertisement(someContent, "First Video", 5000, 1, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 1, 15 * 60));
        add(new Advertisement(someContent, "_Third Video", 400, 1, 10 * 60));
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));/* */
/*        videos.add(new Advertisement(someContent, "Video #4", 10, 2, 3 * 60));  //11 min
        videos.add(new Advertisement(someContent, "Video #5", 10, 2, 3 * 60));  //11 min*/

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
