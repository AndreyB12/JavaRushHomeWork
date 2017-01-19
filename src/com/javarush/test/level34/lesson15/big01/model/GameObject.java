package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by butkoav on 19.01.2017.
 */
public abstract class GameObject
{
    private int x, y, whith, height;

    public GameObject(int x, int y, int whith, int height)
    {
        this.x = x;
        this.y = y;
        this.whith = whith;
        this.height = height;
    }

    public GameObject(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.whith = Model.FIELD_SELL_SIZE;
        this.height = Model.FIELD_SELL_SIZE;
    }

    abstract void draw(Graphics graphics);

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getWhith()
    {
        return whith;
    }

    public void setWhith(int whith)
    {
        this.whith = whith;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
}
