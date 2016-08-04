package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;


public class Solution
{
    public static void main(String[] args)
    {

        ArrayList<Human> family = new ArrayList<>();
        family.add(new Human("GF1", true, 78));
        family.add(new Human("GF2", false, 80));
        family.add(new Human("GM1", true, 70));
        family.add(new Human("GM2", false, 68));
        family.add(new Human("F", true, 50, family.get(0), family.get(2)));
        family.add(new Human("M", false, 45, family.get(1), family.get(3)));
        family.add(new Human("Ch1", true, 15, family.get(4), family.get(5)));
        family.add(new Human("Ch2", true, 5, family.get(4), family.get(5)));
        family.add(new Human("Ch3", false, 10, family.get(4), family.get(5)));

        for (Human h : family)
        {
            System.out.println(h);
        }

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = null;
            this.mother = null;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
