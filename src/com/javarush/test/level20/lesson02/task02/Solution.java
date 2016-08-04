package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
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
            String your_file_name = "e:\\JavaRush.dat";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setCountry(User.Country.UKRAINE);
            user.setFirstName("Andrey");
            user.setLastName("Butko");
            user.setBirthDate(new SimpleDateFormat("yyyy.MM.dd").parse("1983.06.12"));
            user.setMale(true);
            javaRush.users.add(user);
            user = new User();
            user.setCountry(User.Country.UKRAINE);
            user.setFirstName("Anna");
            user.setLastName("Butko");
            user.setBirthDate(new SimpleDateFormat("yyyy.MM.dd").parse("1983.02.20"));
            user.setMale(false);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();
            outputStream.close();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));


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

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter pw = new PrintWriter(outputStream);
            pw.print(this.toString() + "|");
            for (User user : users)
            {
                pw.print(user.getFirstName() + "|" + user.getLastName() + "|" +
                        new SimpleDateFormat("yyyy.MM.dd").format(user.getBirthDate()) + "|" + user.isMale() + "|" + user.getCountry().getDisplayedName() + "|");
            }
            pw.println();
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line[] = br.readLine().split("\\|");
            for (int i = 1; i < line.length; i += 5)
            {
                User user = new User();
                user.setFirstName(line[i]);
                user.setLastName(line[i + 1]);
                user.setBirthDate(new SimpleDateFormat("yyyy.MM.dd").parse(line[i + 2]));
                user.setMale(Boolean.valueOf(line[i + 3]));
                switch (line[i + 4])
                {
                    case "Ukraine":
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    case "Russia":
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    case "Other":
                        user.setCountry(User.Country.OTHER);
                        break;
                }
                this.users.add(user);
            }
        }
    }
}
