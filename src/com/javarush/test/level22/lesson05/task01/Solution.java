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
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("asfsdf sdfsdf sdf"));
        System.out.println(getPartOfString("sdfsdf"));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null) throw new TooShortStringException();

        String result = "";
        int s = string.indexOf(' ');
        if (s < 0) throw new TooShortStringException();

        return result;
    }

    public static class TooShortStringException extends Exception
    {
    }
}
