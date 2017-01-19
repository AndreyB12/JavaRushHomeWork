package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Box;
import com.javarush.test.level34.lesson15.big01.model.Home;
import com.javarush.test.level34.lesson15.big01.model.Player;
import com.javarush.test.level34.lesson15.big01.model.Wall;

import javax.swing.*;
import java.awt.*;

;

/**
 * Created by butkoav on 19.01.2017.
 */
public class Field extends JPanel
{
    private View view;
    private EventListener eventListener;

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }
    public Field(View view)
    {
        this.view = view;
    }

    @Override
    public void paint(Graphics g)
    {
        Player player = new Player(100, 100);
        Box box = new Box(150, 150);
        Home home = new Home(200, 200);
        Wall wall = new Wall(300,300);
        box.draw(g);
        player.draw(g);
        home.draw(g);
        wall.draw(g);
    }
}
