package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String url = reader.readLine();
            reader.close();
            ArrayList<Parameter> parameters = getParamsFromURL(url);
         //   System.out.println(parameters);

            if (parameters.size() > 0)
            {
                System.out.print(parameters.get(0).name);
                for (int i = 1; i < parameters.size(); i++)
                {
                    System.out.print(" " + parameters.get(i).name);
                }
            }
            System.out.println("");
            for (Parameter parameter : parameters)
            {
                if (parameter.name.equals("obj"))
                {
                    try
                    {
                        double d = Double.parseDouble(parameter.value);
                        alert(d);
                    }
                    catch (NumberFormatException e)
                    {
                        alert(parameter.value);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static ArrayList<Parameter> getParamsFromURL(String url)
    {
        ArrayList<Parameter> paramList = new ArrayList<>();
        String paramsString = url.substring(url.indexOf('?') + 1).replaceAll("\\?", "");
        String[] params = paramsString.split("&");

        for (int i = 0; i < params.length; i++)
        {
            String param[] = params[i].split("=");
            String name = param[0];
            String vl = (param.length > 1) ? param[1] : null;
            if (name.length()>0) paramList.add(new Parameter(name, vl));
        }
        return paramList;
    }


    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }

    private static class Parameter
    {
        public String name;
        public String value;

        public Parameter(String name, String value)
        {
            this.name = name;
            this.value = value;
        }
    }
}
