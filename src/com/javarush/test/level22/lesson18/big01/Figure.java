package com.javarush.test.level22.lesson18.big01;

/**
 * Created by butkoav on 12.09.2016.
 */
public class Figure
{
    int x;
    int y;
    int[][] matrix;

    public Figure(int x, int y, int[][] matrix)
    {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public void left()
    {

    }

    public void right()
    {
    }

    public void down()
    {
    }

    public void up()
    {
    }

    public void downMaximum()
    {
    }

    public void rotate()
    {
    }

    public boolean isCurrentPositionAvailable()
    {
        return true;
    }

    public void landed()
    {
    }


}
