package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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
                    switch (args[2].toLowerCase())
                    {
                        case "м":
                            allPeople.add(Person.createMale(args[1], toDate(args[3])));
                            System.out.println(allPeople.size()-1);
                            break;
                        case "ж":
                            allPeople.add(Person.createFemale(args[1], toDate(args[3])));
                            System.out.println(allPeople.size()-1);
                            break;
                    }

                    break;
                case "-u":
                {
                    Person person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(args[2]);
                    person.setSex(toSex(args[3]));
                    person.setBirthDay(toDate(args[4]));
                    break;
                }
                case "-d":
                {
                    Person person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                    break;
                }
                case "-i":
                {
                    int id = Integer.parseInt(args[1]);
                    StringBuilder sb = new StringBuilder();
                    Person person = allPeople.get(id);
                    sb.append((person.getName()==null)?"":person.getName()).append(" ").append(sexToString(person.getSex())).append(" ").append(dateToString(person.getBirthDay()));
                    System.out.println(sb.toString());
                }
            }
        }
        catch (Exception e)
        {
        }

    }

    private static String sexToString(Sex sex)
    {
        if (sex == null) return "";
        switch (sex)
        {
            case MALE:
                return "м";
            case FEMALE:
                return "ж";
        }
        return null;
    }

    private static Sex toSex(String sex) throws Exception
    {
        switch (sex)
        {
            case "м":
                return Sex.MALE;
            case "ж":
                return Sex.FEMALE;
        }
        throw new Exception();
    }

    private static Date toDate(String s) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = format.parse(s);
        return date;
    }

    private static String dateToString(Date date)
    {
        if (date == null) return "";
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return format.format(date);
    }
}
