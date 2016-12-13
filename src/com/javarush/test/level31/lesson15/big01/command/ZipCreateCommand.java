package com.javarush.test.level31.lesson15.big01.command;


/**
 * Created by butkoav on 12.12.2016.
 */
public class ZipCreateCommand extends ZipCommand
{

    @Override
    public void execute() throws Exception
    {
        // new ZipFileManager(Paths.get("e:\\zipzip\\test.zip")).createZip(Paths.get("E:\\temp\\test"));
    }
}
