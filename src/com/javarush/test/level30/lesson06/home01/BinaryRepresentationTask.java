package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by butkoav on 17.11.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{
    private int number;

    public BinaryRepresentationTask(int numb)
    {
        this.number = numb;
    }

    @Override
    protected String compute()
    {
        int a = number % 2;
        int b = number / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            return task.fork().join() + result;
        }
        return result;
    }
}
