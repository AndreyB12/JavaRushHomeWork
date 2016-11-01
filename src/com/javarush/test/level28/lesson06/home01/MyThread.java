package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by butkoav on 01.11.2016.
 */
public class MyThread extends Thread
{
    static AtomicInteger priority = new AtomicInteger(0);

    public MyThread()
    {
        super();
        this.setPriority(incrementAndGetPriority());
    }

    public MyThread(Runnable target)
    {
        super(target);
        this.setPriority(incrementAndGetPriority());
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        this.setPriority(incrementAndGetPriority());
    }

    public MyThread(String name)
    {
        super(name);
        this.setPriority(incrementAndGetPriority());
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        this.setPriority(incrementAndGetPriority());
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        this.setPriority(incrementAndGetPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        int pr = incrementAndGetPriority();
        this.setPriority(pr > group.getMaxPriority() ? group.getMaxPriority() : pr);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        int pr = incrementAndGetPriority();
        this.setPriority(pr > group.getMaxPriority() ? group.getMaxPriority() : pr);
    }

    private static int incrementAndGetPriority()
    {
        synchronized (priority)
        {
            int pr = priority.incrementAndGet();
            if (pr == Thread.MAX_PRIORITY) priority.set(0);
            return pr;
        }
    }
}
