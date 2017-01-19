package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by butkoav on 19.01.2017.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics g)
    {
        int tx = (getX() + Model.FIELD_SELL_SIZE) / 2;
        int ty = (getY() + Model.FIELD_SELL_SIZE) / 2;
        g.setColor(Color.RED);
        g.fillOval(tx, ty,getWidth(), getHeight());
    }
}
