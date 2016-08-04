package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String... args) throws IOException
    {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();

    }


    public void fillInPropertiesMap() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        //FileReader fr = new FileReader("e:\\test.properties");
        reader.close();
        Properties props = new Properties();
        props.load(fr);
        fr.close();

        for (String name : props.stringPropertyNames())
            properties.put(name, props.getProperty(name));
    }

    public void save(OutputStream outputStream) throws Exception
    {
        PrintWriter pw = new PrintWriter(outputStream);
        pw.print(this + "|");
        for (String key : properties.keySet())
        {
            pw.print(key + "|" + properties.get(key) + "|");
        }
        pw.println();
        pw.flush();
    }

    public void load(InputStream inputStream) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String[] line;
        line = br.readLine().split("\\|");
        for (int i = 1; i < line.length; i += 2)
        {
            properties.put(line[i], line[i + 1]);
        }
    }
}
