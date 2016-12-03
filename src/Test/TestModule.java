package Test;


import java.io.IOException;

import static com.javarush.test.level31.lesson04.home01.Solution.copy;

/**
 * Created by butkoav on 21.04.2016.
 */
public class TestModule
{
    public static void main(String[] aa) throws IOException
    {
        copy("e:\\temp\\source.txt","e:\\temp\\destination.txt");
    }
}