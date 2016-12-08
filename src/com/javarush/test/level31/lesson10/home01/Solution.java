package com.javarush.test.level31.lesson10.home01;

import java.io.*;
import java.util.Properties;

/* Читаем конфиги
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.
Подсказка: возможно, Вам понадобится File.separator.
*/
public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("E:\\Projects\\JavaRushHomeWork\\src\\com\\javarush\\test\\level31\\lesson10\\home01\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("E:\\Projects\\JavaRushHomeWork\\src\\com\\javarush\\test\\level31\\lesson10\\home01\\properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("E:\\Projects\\JavaRushHomeWork\\src\\com\\javarush\\test\\level31\\lesson10\\home01\\notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName)
    {
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(fileName))
        {
            properties.loadFromXML(is);
            return properties;
        }
        catch (IOException e)
        {
           // e.printStackTrace();
        }

        try(FileReader fr = new FileReader(fileName))
        {
            properties.load(fr);
        }
        catch (IOException e)
        {
          //  e.printStackTrace();
        }

        return properties;
    }
}
