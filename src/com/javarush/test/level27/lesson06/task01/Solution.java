package com.javarush.test.level27.lesson06.task01;

/* Убираем deadLock
Используя стратегию избегания deadLock-а сделайте так, чтобы он не возник.
Метод main не участвует в тестировании.
Действуйте аналогично примеру из лекций.
Изменения вносите только в safeMethod.
*/
public class Solution
{
    public void safeMethod(Object obj1, Object obj2)
    {
        Object obj_1;
        Object obj_2;
        if (obj1.toString().compareTo(obj2.toString()) > 0)
        {
            obj_1 = obj1;
            obj_2 = obj2;
        } else
        {
            obj_1 = obj2;
            obj_2 = obj1;
        }
        synchronized (obj_1)
        {
            longTimeMethod();
            synchronized (obj_2)
            {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod()
    {
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException ignored)
        {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2)
    {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args)
    {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread()
        {
            @Override
            public void run()
            {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread()
        {
            @Override
            public void run()
            {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
