package com.javarush.test.level25.lesson05.home01;

/* Мониторинг состояния нити
В отдельном классе создать нить LoggingStateThread,
которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread target = new Thread()
        {
            @Override
            public void run()
            {

                try
                {
                    sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        };
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        Thread.sleep(1000);
        target.start();  //NEW
        Thread.sleep(1000); //RUNNABLE
        target.join(1000);
        Thread.sleep(1000);
        target.interrupted(); //TERMINATED
        Thread.sleep(1000);
    }

}


