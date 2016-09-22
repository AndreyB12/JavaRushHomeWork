package com.javarush.test.level24.lesson14.big01;

/**
 * Created by butkoav on 22.09.2016.
 */
public class Ball extends BaseObject
{
    double speed, direction, dx, dy;
    boolean isFrozen;

    public double getSpeed()
    {
        return speed;
    }

    public double getDirection()
    {
        return direction;
    }

    public double getDx()
    {
        return dx;
    }

    public double getDy()
    {
        return dy;
    }

    public boolean isFrozen()
    {
        return isFrozen;
    }

    public Ball(double x, double y, double speed, double direction)
    {
        super(x, y, 1);
        isFrozen = true;
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.setPoint(x, y, 'O');
    }

    public void start()
    {
        isFrozen = false;
    }

    @Override
    public void move()
    {
        if (isFrozen) return;
        x += dx;
        y += dy;
    }
}
