package com.javarush.test.level24.lesson14.big01;

/**
 * Created by butkoav on 22.09.2016.
 */
public class Canvas
{
    int width, height;
    char[][] matrix;

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public char[][] getMatrix()
    {
        return matrix;
    }

    public Canvas(int width, int height)
    {
        this.height = height;
        this.width = width;
    }
}
