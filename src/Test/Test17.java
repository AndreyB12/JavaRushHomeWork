package Test;

import com.javarush.test.level17.lesson10.bonus02.Solution;
import com.sun.rmi.rmid.ExecOptionPermission;

/**
 * Created by butkoav on 05.06.2016.
 */
public class Test17
{
    public static void main(String[] args) throws Exception
    {
        Thread.setDefaultUncaughtExceptionHandler(new com.javarush.test.level25.lesson09.task03.Solution());
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

    }

}
