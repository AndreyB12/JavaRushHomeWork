package com.javarush.test.level28.lesson15.big01;


import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by butkoav on 19.11.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HtmlView view = new HtmlView();
        Strategy strategyHH = new HHStrategy();
        Strategy strategyMK = new MoikrugStrategy();
        Provider providerHH = new Provider(strategyHH);
        Provider providerMK = new Provider(strategyMK);
        Model model = new Model(view,providerHH,providerMK);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
