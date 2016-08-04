package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String firstName = "unknown";
        String secondName = "unknown";
        int age = -1;
        boolean sex = true;
        String eMail = "unknown";
        int insurance = -1;

        public Human(String firstName, String secondName)
        {
            this.firstName = firstName;
            this.secondName = secondName;
        }
        public Human( int insurance,String firstName, String secondName)
        {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = 0;
            this.insurance = insurance;
        }

        public Human(String firstName, String secondName, int age)
        {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
        }

        public Human(String firstName, String secondName, int age, boolean sex)
        {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstName, String secondName, boolean sex)
        {
            this.firstName = firstName;
            this.secondName = secondName;
            this.sex = sex;
        }

        public Human(String firstName, String secondName, String eMail)
        {
            this.firstName = firstName;
            this.secondName = secondName;
            this.eMail = eMail;
        }

        public Human(String firstName, String secondName, int age, boolean sex, String eMail, int insurance)
        {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
            this.eMail = eMail;
            this.insurance = insurance;
        }

        public Human(int age, boolean sex, String eMail)
        {
            this.age = age;
            this.sex = sex;
            this.eMail = eMail;
        }

        public Human(String eMail, boolean sex, int age, String secondName, String firstName)
        {
            this.eMail = eMail;
            this.sex = sex;
            this.age = age;
            this.secondName = secondName;
            this.firstName = firstName;
        }

        public Human(String firstName)
        {
            this.firstName = firstName;
        }
    }
}
