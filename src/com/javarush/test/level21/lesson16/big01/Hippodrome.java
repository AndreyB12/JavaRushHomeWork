package com.javarush.test.level21.lesson16.big01;
import java.util.ArrayList;

/**
 * Created by butkoav on 07.09.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String... args) throws InterruptedException
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Blacky", 3, 0));
        game.getHorses().add(new Horse("Rudy", 3, 0));
        game.getHorses().add(new Horse("Flower", 3, 0));

        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move()
    {
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).move();
        }
    }

    public void print()
    {
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        double maxdistance = 0;
        Horse winner = null;
        for (int i = 0; i < horses.size(); i++)
        {
            if (horses.get(i).getDistance() > maxdistance)
            {
                winner = horses.get(i);
                maxdistance = winner.getDistance();
            }
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println(String.format("Winner is %s!",getWinner().getName()));
    }

}
