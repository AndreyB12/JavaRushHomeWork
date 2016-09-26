package com.javarush.test.level25.lesson05.home01;

/**
 * Created by butkoav on 27.09.2016.
 */
public class LoggingStateThread extends Thread
{
    private Thread loggingThread;
    Thread.State lastState = null;
    Thread.State currState = null;
    public LoggingStateThread(Thread loggingThread)
    {
        super();
        this.loggingThread = loggingThread;
        setDaemon(true);
        currState = loggingThread.getState();
        lastState=currState;
        System.out.println(currState);
    }

    public void run()
    {

        while (!isInterrupted())
        {
            currState = loggingThread.getState();
            if (currState != lastState)
            {
                System.out.println(currState);
                lastState = currState;
            }
            if (currState == Thread.State.TERMINATED) interrupt();
        }
    }
}
