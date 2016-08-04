package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, Human> family = new HashMap<>();

        family.put("GrandPa1", new Human("GranPa1", true, 73));
        family.put("GrandPa2", new Human("GranPa2", true, 70));
        family.put("GrandMa1", new Human("GranMa1", false, 70));
        family.put("GrandMa2", new Human("GranMa2", false, 70));

        family.put("Ma", new Human("Ma", false, 40));
        family.put("Pa", new Human("Pa", true, 45));

        family.put("Chield1", new Human("Tom", true, 15));
        family.put("Chield2", new Human("Ted", true, 13));
        family.put("Chield3", new Human("Fiona", false, 10));

        family.get("GrandPa1").children.add(family.get("Ma"));
        family.get("GrandMa1").children.add(family.get("Ma"));

        family.get("GrandMa2").children.add(family.get("Pa"));
        family.get("GrandPa2").children.add(family.get("Pa"));

        family.get("Ma").children.add(family.get("Chield1"));
        family.get("Ma").children.add(family.get("Chield2"));
        family.get("Ma").children.add(family.get("Chield3"));
        family.get("Pa").children.add(family.get("Chield1"));
        family.get("Pa").children.add(family.get("Chield2"));
        family.get("Pa").children.add(family.get("Chield3"));

        for (Human human : family.values())
        {
            System.out.println(human);
        }

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        public ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
