package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        String str = "";

        List vm = new ArrayList();
        String[] vords = {"Мама", "Мыла", "Раму"};
        for (int i = 0; i < vords.length; i++)
        {
            vm.add(vords[i]);
        }
        mixCollection(vm, "");
    }

    static void mixCollection(List list, String str)
    {
        String str1;
        if (list.size() == 0)
        {
            System.out.println(str);
        } else
        {
            for (int i = 0; i < list.size(); i++)
            {
                str1 = str + list.get(i);
                List l1 = new ArrayList(list);
                l1.remove(i);
                mixCollection(l1, str1);
            }
        }
    }
}


