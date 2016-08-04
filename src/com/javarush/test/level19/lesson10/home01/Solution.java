package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        while (fr.ready())
        {
            line = fr.readLine().split(" ");
            if (hm.containsKey(line[0]))
            {
                hm.put(line[0], hm.get(line[0]) + Float.valueOf(line[1]));
            } else
            {
                hm.put(line[0],Float.valueOf(line[1]));
                names.add(line[0]);
            }
        }
        fr.close();
        Collections.sort(names);

        for (String name: names             )
        {
            System.out.println(name + " " + hm.get(name));
        }
    }
}
