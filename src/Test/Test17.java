package Test;

import com.javarush.test.level17.lesson10.bonus02.Solution;

/**
 * Created by butkoav on 05.06.2016.
 */
public class Test17
{
    public static void main(String[] args)
    {
        SubTest subtest = new SubTest();
        subtest.subtest();
    }
    static void test()
    {
        System.out.println("test");
    }
    static public class SubTest
    {
         void subtest()
        {
            test();
        }
    }
}
