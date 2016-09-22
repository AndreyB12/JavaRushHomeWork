package com.javarush.test.level24.lesson14.big01;

import java.util.ArrayList;

/**
 * Created by butkoav on 22.09.2016.
 */
public class Arcanoid
{
    int height,width;
    Ball ball;
    Stand stand;
    ArrayList<Brick> bricks;
    public static Arcanoid game;
    public Ball getBall()
    {
        return ball;
    }

    public void setBall(Ball ball)
    {
        this.ball = ball;
    }

    public Stand getStand()
    {
        return stand;
    }

    public void setStand(Stand stand)
    {
        this.stand = stand;
    }

    public ArrayList<Brick> getBricks()
    {
        return bricks;
    }

    public void setBricks(ArrayList<Brick> bricks)
    {
        this.bricks = bricks;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public Arcanoid(int height, int width)
    {
        this.height = height;
        this.width = width;
    }

    public static void main(String...args)
    {}

    public void run()
    {

    }
    public void move(){}
}
