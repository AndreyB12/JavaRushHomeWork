package com.javarush.test.level31.lesson15.big01.command;

/**
 * Created by butkoav on 12.12.2016.
 */
public abstract class ZipCommand implements Command
{
    @Override
    public abstract void execute() throws Exception;
}
