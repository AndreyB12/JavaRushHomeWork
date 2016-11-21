package com.javarush.test.level28.lesson15.big01;


import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.model.Strategy;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by butkoav on 19.11.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HtmlView view = new HtmlView();
        Strategy strategy = new HHStrategy();
        Provider provider = new Provider(strategy);
        Provider[] providers = {provider};
        Model model = new Model(view,providers);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();

    }
}
