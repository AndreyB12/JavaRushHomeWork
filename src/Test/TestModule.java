package Test;

//import static com.javarush.test.level08.lesson08.task03.Solution.createMap;

/**
 * Created by butkoav on 21.04.2016.
 */
public class TestModule
{
    private static String s;
    private static TestClass testClass = new TestClass(0);

    public static void main(String[] aa)
    {
       Thread t = new T1();
        t.start();
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {}
        for (int i = 0; i < 10; i++)
        {
            synchronized (testClass)
            {
                testClass.setI(testClass.getI() + 1);
            }
            System.out.println(testClass.getI());
        }
    }
    private static class T1 extends Thread
    {
        @Override
        public void run()
        {
            test(testClass);
        }
        private synchronized void test(TestClass tc)
        {
            //synchronized (tc)
            //{
                System.out.println(testClass.getI());
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException e)
                {
                }
                System.out.println(testClass.getI());
           // }
        }
    }

    public static class TestClass
    {
        private int i;

        public TestClass(int i)
        {
            this.i = i;
        }

        public int getI()
        {
            return i;
        }

        public void setI(int i)
        {
            this.i = i;
        }
    }

}