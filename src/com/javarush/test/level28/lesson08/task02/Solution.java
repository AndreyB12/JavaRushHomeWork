package com.javarush.test.level28.lesson08.task02;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* Знакомство с ThreadPoolExecutor
1. В методе main создай очередь LinkedBlockingQueue<Runnable>
2. В цикле добавь в очередь 10 тасок Runnable.
3. У каждой таски в методе run вызови метод doExpensiveOperation с порядковым номером таски начиная с 1, см. пример вывода
4. Создай объект ThreadPoolExecutor со следующими параметрами:
- основное количество трэдов (ядро) = 3
- максимальное количество трэдов = 5
- время удержания трэда живым после завершения работы = 1000
- тайм-юнит - миллисекунды
- созданная в п.1. очередь с тасками
5. Запусти все трэды, которые входят в основное кол-во трэдов - ядро), используй метод prestartAllCoreThreads
6. Запрети добавление новых тасок на исполнение в пул (метод shutdown)
7. Дай экзэкьютору 5 секунд на завершение всех тасок (метод awaitTermination и параметр TimeUnit.SECONDS)
Не должно быть комментариев кроме приведенного output example
*/
public class Solution
{
    public static void main(String[] args) throws InterruptedException
    {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        for (int i = 1; i < 11; i++)
        {
            queue.add(new Runnable()
            {
                private int localID;

                @Override
                public void run()
                {
                    doExpensiveOperation(localID);
                }

                public Runnable setLocalID(int ID)
                {
                    localID = ID;
                    return this;
                }
            }.setLocalID(i));
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,1000,TimeUnit.MILLISECONDS,queue);
        executor.prestartAllCoreThreads();
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

    }

    private static void doExpensiveOperation(int localId)
    {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
