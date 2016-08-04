package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        String[] line;
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        String name = "";
        int day = 0;
        int month = 0;
        int year = 0;
        int i = 0;
        Date birthday;
        while (fr.ready())
        {
            line = fr.readLine().split(" ");
            i = 1;
            day = 0;
            month = 0;
            year = 0;
            name = line[0];
            while (i < line.length)
            {
                try
                {
                    day = Integer.valueOf(line[i]);
                    break;
                }
                catch (NumberFormatException e)
                {
                    name = name + " " + line[i];
                    i++;
                }
            }
            month = Integer.valueOf(line[i+1]);
            year = Integer.valueOf(line[i+2]);
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(year,month-1,day);
            birthday =calendar.getTime();


                    PEOPLE.add(new Person(name,birthday));
        }
        fr.close();
    }

}
