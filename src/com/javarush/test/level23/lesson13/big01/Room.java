package com.javarush.test.level23.lesson13.big01;

/**
 * Created by butkoav on 18.09.2016.
 * Задание 9
 * Еще остался самый главный класс - Room.
 * Что нам нужно для его описания?
 * Размеры комнаты (width и height) - раз.
 * Змея - два
 * Мышь - три.
 */
public class Room
{
    int width, height;
    Snake snake;
    Mouse mouse;

    public Room(int width, int height, Snake snake)
    {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Snake getSnake()
    {
        return snake;
    }

    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public void setMouse(Mouse mouse)
    {
        this.mouse = mouse;
    }

    public static void main(String... args)
    {

    }
}
