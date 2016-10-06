package com.javarush.test.level25.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by butkoav on 06.10.2016.
 */
public class Space
{
    int width;
    int height;
    SpaceShip ship;
    ArrayList<Ufo> ufos = new ArrayList<>();
    ArrayList<Rocket> rockets = new ArrayList<>();
    ArrayList<Bomb> bombs = new ArrayList<>();

    public void setShip(SpaceShip ship)
    {
        this.ship = ship;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public SpaceShip getShip()
    {
        return ship;
    }

    public ArrayList<Ufo> getUfos()
    {
        return ufos;
    }

    public ArrayList<Rocket> getRockets()
    {
        return rockets;
    }

    public ArrayList<Bomb> getBombs()
    {
        return bombs;
    }

    public Space(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public static void main(String... args)
    {

    }
    public void run(){}
    public void draw(){}
    public void sleep(int ms){}
}
