package com.javarush.test.level14.lesson06.home01;

/**
 * Created by butkoav on 22.05.2016.
 */
public class RussianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 3;
    }
    public String getDescription()
    {
        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",Country.RUSSIA ,this.getCountOfEggsPerMonth());
    }
}
