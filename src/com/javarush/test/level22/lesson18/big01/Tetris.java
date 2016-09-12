package com.javarush.test.level22.lesson18.big01;

/**
 * Created by butkoav on 12.09.2016.
 */
public class Tetris
{
    public static Tetris game;
    private Field field;
    private Figure figure;

    public static void main(String... args)
    {
        game = new Tetris();
        game.run();
    }

    public void run()
    {

    }

    public void step()
    {

    }


    public Field getField()
    {
        return field;
    }

    public Figure getFigure()
    {
        return figure;
    }
}
