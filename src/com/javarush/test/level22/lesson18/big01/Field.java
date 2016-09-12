package com.javarush.test.level22.lesson18.big01;

/**
 * Created by butkoav on 12.09.2016.
 */
public class Field
{
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height)
    {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }
}
