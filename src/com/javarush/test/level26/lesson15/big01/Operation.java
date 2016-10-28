package com.javarush.test.level26.lesson15.big01;

/**
 * Created by butkoav on 11.10.2016.
 */
public enum Operation
{
    LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException
    {
        try
        {
            if (i == 0) throw new IllegalArgumentException();
            return Operation.values()[i];
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException();
        }
    }
}
