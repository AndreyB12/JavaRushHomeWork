package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by butkoav on 10.11.2016.
 */
public class TestAdvertManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    public TestAdvertManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos(){
        List<Advertisement> videos = new ArrayList<>();
        boolean haveVideo = false;
        Comparator<Advertisement> comparator = new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if(o2.getAmountPerOneDisplaying() == o1.getAmountPerOneDisplaying()) {
                    long costRepSec1 = o1.getAmountPerOneDisplaying()*1000/o1.getDuration();
                    long costRepSec2 = o2.getAmountPerOneDisplaying()*1000/o2.getDuration();
                    return Long.compare(costRepSec1, costRepSec2);
                }
                return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
            }
        };
        for (Advertisement adver: storage.list()) {
            if (adver.getDuration() <= timeSeconds && adver.getHits() > 0){
                videos.add(adver);
                haveVideo = true;
            }
        }
        if (!haveVideo){
            throw new NoVideoAvailableException();
        }
        List<List<Advertisement>> totalResult = new ArrayList<>();
        rekurs(videos, 0, totalResult, videos);
        List<Advertisement> finalList;
        if (!totalResult.isEmpty()){
            finalList = videoChoise(totalResult);
            Collections.sort(finalList, comparator);
        }
        else{
            finalList = videos;
            Collections.sort(finalList, comparator);}
        for (Advertisement r: finalList) {
            int oneSecPrice = (int) (r.getAmountPerOneDisplaying()*1000/r.getDuration());
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", r.getName(), r.getAmountPerOneDisplaying(), oneSecPrice));
            r.revalidate();
        }
    }
    private void rekurs(List<Advertisement> input, int dur, List<List<Advertisement>> totalResult, List<Advertisement> videos ){
        for (Advertisement x:input) {
            if (dur + x.getDuration() <= timeSeconds){
                List<Advertisement> withoutX = new ArrayList<>();
                withoutX.addAll(input);
                withoutX.remove(x);
                rekurs(withoutX, dur + x.getDuration(), totalResult, videos);
            }
            else{
                List<Advertisement> result = new ArrayList<>();
                result.addAll(videos);
                result.removeAll(input);
                totalResult.add(result);
                break;
            }
        }
    }
    private List<Advertisement> videoChoise(List<List<Advertisement>> input){
        Comparator<List<Advertisement>> comparator = new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                long totalSum1 = 0;
                long totalSum2 = 0;
                for (Advertisement x:o1) {
                    totalSum1 += x.getAmountPerOneDisplaying();
                }
                for (Advertisement x:o2) {
                    totalSum2 += x.getAmountPerOneDisplaying();
                }
                if (totalSum1 == totalSum2){
                    long timeSec1 = 0;
                    long timeSec2 = 0;
                    for (Advertisement x:o1) {
                        timeSec1 += x.getDuration();
                    }
                    for (Advertisement x:o2) {
                        timeSec2 += x.getDuration();
                    }
                    if (timeSec1 == timeSec2){
                        return o1.size() - o2.size();
                    }
                    return Long.compare(timeSec2, timeSec1);
                }
                return Long.compare(totalSum2, totalSum1);
            }
        };
        Collections.sort(input, comparator);
        return input.get(0);
    }
}
