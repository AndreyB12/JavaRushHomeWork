package com.javarush.test.level14.lesson06.home01;

import java.text.Format;

/**
 * Created by butkoav on 22.05.2016.
 */
public class BelarusianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
        {
        return 20;
    }
    public String getDescription()
    {
        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",Country.BELARUS ,this.getCountOfEggsPerMonth());
    }
}
