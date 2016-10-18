package com.javarush.test.level26.lesson15.big01;

/**
 * Created by butkoav on 11.10.2016.
 */
public enum Operation
{
    INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException
    {
        try{ return Operation.values()[i - 1];}
        catch (Exception e){throw new IllegalArgumentException();}
    }
}
