package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String...args) throws CloneNotSupportedException
    {
        A a =new A(1,0);
        B b = new B(1,2,"B");
        C c = new C(3,6,"C");
        A a1 = a.clone();
        System.out.println(a);
        System.out.println(a1);

//        B b1 = b.clone();
//        System.out.println(b);
//        System.out.println(b1);

        C c1 = c.clone();

        System.out.println(c);
        System.out.println(c1);
    }
    public static class A implements Cloneable
    {
        private int i;
        private int j;

        public A(int i, int j)
        {
            this.i = i;
            this.j = j;
        }

        public int getI()
        {
            return i;
        }

        public int getJ()
        {
            return j;
        }

        @Override
        public A clone() throws CloneNotSupportedException
        {
            return (A) super.clone();
        }
    }

    public static class B extends A
    {
        private String name;

        public B(int i, int j, String name)
        {
            super(i, j);
            this.name = name;
        }

        @Override
        public B clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }

        public String getName()
        {
            return name;
        }
    }

    public static class C extends B
    {
        public C(int i, int j, String name)
        {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException
        {
            return new C(getI(),getJ(),getName());
        }
    }
}
