package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable
{
    public Solution()
    {

    }
    public static void main(String...args) throws IOException, ClassNotFoundException
    {
        com.javarush.test.level20.lesson10.home03.Solution solution = new com.javarush.test.level20.lesson10.home03.Solution();
        B b  = solution.getNewB("B class");
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("e:\\level20.lesson10.home03.dat"));
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("e:\\level20.lesson10.home03.dat"));
        os.writeObject(b);
        os.close();
        B loadedObject= (B) is.readObject();
        is.close();
        System.out.println(b.name);
        System.out.println(loadedObject.name);
    }
    public B getNewB(String name)
    {
        return new B(name);
    }

    public static class A
    {
        protected String name = "A";

        public A()
        {

        }

        public A(String name)
        {
            this.name += name;
        }
    }

    public class B extends A implements Serializable
    {

        public B()
        {

        }
        public B(String name)
        {
            super(name);
            this.name += name;
        }
        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            name = (String)ois.readObject();
        }
        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
            oos.writeObject(this.name);
        }
    }

}
