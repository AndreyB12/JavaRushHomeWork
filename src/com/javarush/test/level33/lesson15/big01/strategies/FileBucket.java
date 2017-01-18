package com.javarush.test.level33.lesson15.big01.strategies;


import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by butkoav on 16.01.2017.
 */
public class FileBucket
{
    private Path path;

    public FileBucket()
    {
        try
        {
            path = Files.createTempFile("bucket_", null);
            path.toFile().deleteOnExit();
            if (path.toFile().exists()) path.toFile().delete();
            path.toFile().createNewFile();
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public long getFileSize()
    {
        try
        {
            return Files.size(path);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
            return 0;
        }
    }

    public void putEntry(Entry entry)
    {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(Files.newOutputStream(path)))
        {
            oos.writeObject(entry);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry()
    {
        Object rslt = null;
        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path)))
        {
            rslt = ois.readObject();
        }
        catch (Exception e)
        {
        }
        if (rslt == null) return null;
        try
        {
            return (Entry) rslt;
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
        return null;
    }

    public void remove()
    {
        try
        {
            path.toFile().delete();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }
}
