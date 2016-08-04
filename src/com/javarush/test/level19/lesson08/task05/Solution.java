package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        PrintStream cnslStream = System.out;
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintCopy printStream = new PrintCopy(fos);
       // PrintStream printStream = new PrintStream(fos);
       // testString.printSomething();
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(cnslStream);
        fos.close();
        reader.close();
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("it's a text for testing");
        }
    }

    static class PrintCopy extends PrintStream
    {
        PrintStream ps;
        public PrintCopy(OutputStream out)
        {
            super(System.out);
            ps = new PrintStream(out);
        }

        @Override
        public void println(String x)
        {

            super.println(x);
            ps.println(x);
        }
    }

}

