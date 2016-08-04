package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream(args[0]);
        int[] charCount = new int[256];
        byte[] fileContent = new byte[fis.available()];
        fis.read(fileContent);
        fis.close();
        for (int i = 0; i < fileContent.length; i++)
        {
            charCount[fileContent[i]]++;
        }
        Arrays.sort(fileContent);
        for (int i = 0; i < fileContent.length; i++)
        {
            if (i == fileContent.length - 1)
            {
                System.out.println((char)fileContent[i] + " " + charCount[fileContent[i]]);
            } else if (fileContent[i] != fileContent[i + 1])
            {
                System.out.println((char)fileContent[i] + " " + charCount[fileContent[i]]);
            }
        }
    }
}
