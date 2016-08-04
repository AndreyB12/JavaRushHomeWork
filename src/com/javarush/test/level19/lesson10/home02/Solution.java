package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String[] line;
        HashMap<String, Float> hm = new HashMap<>();
        List<String> names = new ArrayList<>();
        float max = 0;
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        while (fr.ready())
        {
            line = fr.readLine().split(" ");
            if (hm.containsKey(line[0]))
            {
                hm.put(line[0], hm.get(line[0]) + Float.valueOf(line[1]));
            } else
            {
                hm.put(line[0], Float.valueOf(line[1]));
            }
            if (hm.get(line[0]) > max)
            {
                names.clear();
                names.add(line[0]);
            } else if (hm.get(line[0]) == max) names.add(line[0]);
        }
        fr.close();
        Collections.sort(names);

        for (String name : names)
        {
            System.out.println(name);
        }
    }
}
