package com.javarush.test.level25.lesson16.big01;

/**
 * Created by butkoav on 06.10.2016.
 */
public class Rocket extends BaseObject
{
    public Rocket(double x, double y, double radius)
    {
        super(x, y, radius);
    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.setPoint(x, y, 'R');
    }

    @Override
    public void move()
    {
        y--;
    }
}
