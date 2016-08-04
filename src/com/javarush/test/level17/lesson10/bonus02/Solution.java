package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        try
        {
            switch (args[0])
            {
                case "-c":
                    addPerson(args);
                    break;
                case "-u":
                    updPerson(args);
                    break;
                case "-d":
                    deletePersone(args);
                    break;
                case "-i":
                    getPersonInfo(args);
                    break;
                default:
                    throw new Exception("Не верный первый параметр!");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static synchronized void addPerson(String[] args) throws ParseException
    {

            for (int i = 1; i < args.length; i += 3)
            {
                String name = args[i];
                String sex = args[i + 1];
                Date date = parseDate(args[i + 2]);
                if (sex.equals("м"))
                {
                    allPeople.add(Person.createMale(name, date));

                }
                if (sex.equals("ж"))
                {
                    allPeople.add(Person.createFemale(name, date));

                }
                System.out.println(allPeople.size() - 1);
            }

    }
    private static synchronized void updPerson(String[] args) throws Exception
    {

            for (int i = 1; i < args.length; i += 4)
            {

                int id = Integer.parseInt(args[i]);
                String name = args[i+1];
                String sex = args[i + 2];
                Date date = parseDate(args[i + 3]);
                Person person = allPeople.get(id);

                    person.setName(name);
                    setSex(sex,person);
                    person.setBirthDay(date);

            }

    }
    private static synchronized void deletePersone(String[] args)
    {

            for (int i = 1; i < args.length; i ++)
            {
                int id = Integer.parseInt(args[i]);
                Person person = allPeople.get(id);

                    person.setName(null);
                    person.setSex((Sex) null);
                    person.setBirthDay((Date) null);

            }

    }
    private static synchronized void getPersonInfo(String[] args)
    {

            for (int i = 1; i < args.length; i++)
            {
                int id = Integer.parseInt(args[i]);
                Person person = allPeople.get(id);
                    System.out.println(getFullInfo(person));

            }

    }
    private static Date parseDate(String s) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = format.parse(s);
        return date;
    }

    private static synchronized String getFullInfo(Person person)
    {
        String result;
        StringBuilder sb = new StringBuilder();
        result =  sb.append(person.getName()).append(" ")
                .append(getSexString(person)).append(" ")
                .append(getBirthDayString(person.getBirthDay())).toString();
        return result;
    }
    private static String getBirthDayString(Date date)
    {
        if (date == null) return null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return format.format(date);
    }
    private static void setSex(String sex,Person person) throws Exception
    {
        if(sex.equals("м")) {
            person.setSex(Sex.MALE);
            return;
        }
        if(sex.equals("ж")) person.setSex(Sex.FEMALE);
        else throw new Exception("Не верное значение параметра sex: " + sex);
    }
    private static String getSexString(Person persone)
    {

        return (persone.getSex()==null)?null:(persone.getSex() == Sex.MALE) ? "м" : "ж";
    }
}
