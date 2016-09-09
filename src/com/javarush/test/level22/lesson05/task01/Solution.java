package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String... args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения."));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        try
        {
            int s = string.indexOf(' ');
            int e = string.indexOf(' ', s + 1);
            e = string.indexOf(' ', e + 1);
            e = string.indexOf(' ', e + 1);
            e++;
            while (Character.isAlphabetic(string.charAt(e)))
            {
                e++;
                if (e == string.length()) break;
            }
            return string.substring(s + 1, e);
        }
        catch (Exception e)
        {
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException extends Exception
    {
    }
}
