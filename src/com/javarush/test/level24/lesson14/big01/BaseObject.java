package com.javarush.test.level24.lesson14.big01;

/**
 * Created by butkoav on 22.09.2016.
 */
public abstract class BaseObject
{
    double x, y, radius;

    public BaseObject(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    abstract public void draw();

    abstract public void move();

    public boolean isIntersec(BaseObject o)
    {
        double dx = this.x - o.getX();
        double dy = this.y - o.getY();
        return Math.sqrt(dx * dx + dy * dy) < Math.max(this.radius, o.radius);
    }
}
