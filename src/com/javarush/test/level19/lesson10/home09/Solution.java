package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.OutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream cnlsStrm = System.out;
        PrintStream extendetCnls = new ExtndCnlsStrm(cnlsStrm);

        System.setOut(extendetCnls);
        testString.printSomething();

        System.setOut(cnlsStrm);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");

        }
    }

    static class ExtndCnlsStrm extends PrintStream
    {
        int count = 0;

        public ExtndCnlsStrm(OutputStream out)
        {
            super(out);
        }

        @Override
        public void println(String x)
        {
            if (count % 2 == 0 & count > 0) super.println("JavaRush - курсы Java онлайн");
            super.println(x);
            count++;
        }
    }
}
