package Test;


import com.javarush.test.level31.lesson15.big01.FileManager;

import java.nio.file.Paths;

/**
 * Created by butkoav on 05.06.2016.
 */
public class Test17
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(new FileManager(Paths.get("e:\\temp\\")).getFileList());
    }

}
