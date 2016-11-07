package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by butkoav on 05.11.2016.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = this.initialAmount / this.hits;
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    public int getHits()
    {
        return hits;
    }

    public void revalidate() throws UnsupportedOperationException
    {
        if (hits > 0) hits--;
        else throw new UnsupportedOperationException();

    }
}
