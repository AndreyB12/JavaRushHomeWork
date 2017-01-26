package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by butkoav on 19.01.2017.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        int tx = getX() - Model.FIELD_SELL_SIZE / 2;
        int ty = getY() - Model.FIELD_SELL_SIZE / 2;
        g.setColor(new Color(100,60,0));

        g.fillRect(tx, ty, Model.FIELD_SELL_SIZE, Model.FIELD_SELL_SIZE);
    }
}
