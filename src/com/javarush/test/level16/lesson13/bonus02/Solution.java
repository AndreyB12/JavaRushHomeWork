package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution
{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static class Thread1 extends Thread
    {
        public void run()
        {
            while (true)
            {
            }
        }
    }

    public static class Thread2 extends Thread
    {
        public void run()
        {

            try
            {
                while (true)
                {
                    sleep(1000);
                }
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread
    {
        public void run()
        {
            try
            {
                while (true)
                {

                    sleep(500);
                    System.out.println("Ура");
                }
            }
            catch (InterruptedException e)
            {
            }

        }
    }

    public static class Thread4 extends Thread implements Message
    {
        @Override
        public void showWarning()
        {
            this.interrupt();
            try
            {
                join();
            }
            catch (InterruptedException e)
            {}
        }

        public void run()
        {
            while (!isInterrupted())
            {
                yield();
            }
        }
    }

    public static class Thread5 extends Thread
    {
        public void run()
        {
            int smm = 0;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
            {
                String s;
                while (!(s = reader.readLine()).equals("N"))
                {
                    smm += Integer.parseInt(s);

                }
                System.out.println(smm);
            }
            catch (IOException e)
            {
            }
        }

    }


}
