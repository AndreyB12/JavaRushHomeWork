package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    Thread t;
    String name;
    @Override
    public void run()
    {
        try
        {
            while (!t.isInterrupted())
            {

                System.out.println(name);
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e)
        {

        }


    }

    @Override
    public void start(String threadName)
    {
        name = threadName;
        t = new Thread(this);
        t.setName(threadName);
        t.start();
    }

    @Override
    public void stop()
    {
        t.interrupt();
    }
}
