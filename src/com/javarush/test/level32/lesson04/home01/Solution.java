package com.javarush.test.level32.lesson04.home01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //  StringWriter writer = getAllDataFromInputStream(new FileInputStream("E:\\test.txt"));
        StringWriter writer = getAllDataFromInputStream(null);
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException
    {
        StringWriter sw = new StringWriter();
        if (is == null) return sw;
        InputStreamReader isr = new InputStreamReader(is);

        char[] bufer = new char[1024];
        int cnt;
        while ((cnt = isr.read(bufer)) > 0)
        {
            sw.write(bufer, 0, cnt);
        }

        return sw;

    }
}
