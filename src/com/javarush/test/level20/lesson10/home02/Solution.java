package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution
{
    public A getOriginalObject(ObjectInputStream objectStream)
    {
        try
        {
            Object obj = objectStream.readObject();
            if(obj instanceof B) return (B) obj;
            if(obj instanceof A) return (A) obj;
            return null;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }


    }

    public class A implements Serializable
    {
    }

    public class B extends A
    {
        public B()
        {
            System.out.println("inside B");
        }
    }
}
