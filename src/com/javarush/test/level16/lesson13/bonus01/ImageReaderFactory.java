package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by butkoav on 02.06.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes it) throws IllegalArgumentException
    {
        try
        {
            switch (it)
            {
                case BMP:
                    return new BmpReader();
                case JPG:
                    return new JpgReader();
                case PNG:
                    return new PngReader();
                default:
                    throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        }
        catch (NullPointerException e)
        {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
