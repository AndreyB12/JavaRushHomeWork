package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by butkoav on 30.12.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        if (f.isDirectory()) return true;
        return f.getName().toLowerCase().matches(".+\\.html$|.+\\.htm$");
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
