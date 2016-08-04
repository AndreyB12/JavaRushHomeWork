package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.text.ParseException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        FileWriter fw = new FileWriter(reader.readLine());
        reader.close();
        char cr;
        int i;
        String strNumb = "";
        while (fr.ready())
        {
            cr = (char)fr.read();
            if (Character.isLetterOrDigit(cr))
            {
                strNumb = strNumb + cr;
            }
            if(!fr.ready() || !Character.isLetterOrDigit(cr)){
                try{
                    i=Integer.parseInt(strNumb);
                    fw.write(String.valueOf(i));
                    fw.write(' ');

                }catch (NumberFormatException  e){}
                finally
                {
                    strNumb = "";
                }
            }
        }
        fr.close();
        fw.close();
    }

}
