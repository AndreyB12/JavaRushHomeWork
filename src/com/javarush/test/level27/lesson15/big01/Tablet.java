package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by butkoav on 31.10.2016.
 */
public class Tablet
{
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        Order order = null;

        try
        {
            order = new Order(this);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return;
        }
        processOrder(order);

    }

    public void createTestOrder()
    {
        Order order = null;

        try
        {
            order = new TestOrder(this);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return;
        }
        processOrder(order);

    }

    private void processOrder(Order order)
    {
        if (order.isEmpty()) return;
        ConsoleHelper.writeMessage(order.toString());
        queue.add(order);
        try
        {
            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    @Override
    public String toString()
    {
        return String.format("Tablet{number=%s}", number);
    }
}
