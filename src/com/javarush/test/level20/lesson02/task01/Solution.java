package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {

            //File your_file_name = File.createTempFile("e:\\temp_file", null);
            OutputStream outputStream = new FileOutputStream("e:\\temp_file");
            InputStream inputStream = new FileInputStream("e:\\temp_file");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human
    {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human()
        {
        }

        public Human(String name, Asset... assets)
        {
            this.name = name;
            if (assets != null)
            {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter pw = new PrintWriter(outputStream);
            if (!name.isEmpty())
            {
                pw.println("Human:" + name);
                for (Asset asset : assets)
                {
                    pw.println(asset.getName() + "|" + asset.getPrice());
                }
                pw.println("---");
            }
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while (br.ready())
            {
                String line = br.readLine();
                if (line.substring(0, 6).equals("Human:"))
                {
                    String name = line.substring(6);
                    this.name = name;

                    while (!(line=br.readLine()).equals("---"))
                    {
                        String[] str = line.split("\\|");
                        Asset asset = new Asset(str[0]);
                        asset.setPrice(Double.valueOf(str[1]));
                        this.assets.add(asset);
                    }

                }
            }
        }
    }
}
