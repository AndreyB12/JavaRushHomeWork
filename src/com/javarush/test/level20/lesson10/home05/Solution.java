package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution
{
    public static void main(String args[]) throws Exception
    {
        FileOutputStream fileOutput = new FileOutputStream("temp File");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Person person = new Person("Andrii", "Butko", "Ukr", Sex.MALE);

        outputStream.writeObject(person);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("temp File");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Person loadedObject = (Person) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        // System.out.println(loadedObject.size());
    }

    public static class Person implements Serializable
    {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex
    {
        MALE,
        FEMALE
    }
}
