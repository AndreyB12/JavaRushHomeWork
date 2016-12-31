package Test;


import com.javarush.test.level32.lesson15.big01.HTMLFileFilter;

import java.io.File;

/**
 * Created by butkoav on 05.06.2016.
 */
public class Test17
{
    public static void main(String[] args) throws Exception
    {
        HTMLFileFilter htmlFileFilter = new HTMLFileFilter();
        System.out.println(htmlFileFilter.accept(new File("e:\\test.htm")));
    }

}
