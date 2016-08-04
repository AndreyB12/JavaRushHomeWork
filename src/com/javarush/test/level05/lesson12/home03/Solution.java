package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tommCat = new Cat("Tom", 15, 10, "Blue");
        Cat butchCat = new Cat("Butch", 15, 10, "Black and White");
        Dog pikeDog=new Dog("Spike",50,5,"Gray");
        Dog tykeDog=new Dog("Tyke",10,2,"Gray");
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        String name;
        int height;
        int tail;
        String color;

        public Cat(String name, int height, int tail, String color)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
            this.color = color;
        }
    }

    public static class Dog
    {
        String name;
        int height;
        int tail;
        String color;

        public Dog(String name, int height, int tail, String color)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
            this.color = color;
        }
    }

}
