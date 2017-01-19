package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by butkoav on 19.01.2017.
 */
public class LevelLoader
{
    public LevelLoader(Path levels)
    {

    }

    public GameObjects getLevel(int level)
    {
        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(200, 200));
        walls.add(new Wall(220, 200));
        walls.add(new Wall(180, 200));

        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(100, 100));
        Set<Home> homes = new HashSet<>();
        homes.add(new Home(240, 200));
        Player player = new Player(150, 150);
        GameObjects go = new GameObjects(walls, boxes, homes, player);
        return go;
    }
}
