package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by butkoav on 07.09.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String...args)
    {
        Hippodrome game = new Hippodrome();
        game.getHorses().add(new Horse("Blacky",3,0));
        game.getHorses().add(new Horse("Rudy",3,0));
        game.getHorses().add(new Horse("Flower",3,0));

    }
}
