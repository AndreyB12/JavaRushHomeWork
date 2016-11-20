package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.model.Strategy;

/**
 * Created by butkoav on 19.11.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        Strategy strategy = new HHStrategy();

        Provider provider = new Provider(strategy);

        Controller controller = new Controller(provider);
        controller.scan();
    }
}
