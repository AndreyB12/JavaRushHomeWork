package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution
{
    public static void main(String[] args)
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b = 0;

        do
        {
            baos.reset();
            for (int i = 0; i < 8; i++)
            {
                switch ((int) (Math.random() * 3.0))
                {
                    case 0:
                        b = 48 + (int) (Math.random() * 10);
                        break;
                    case 1:
                        b = 65 + (int) (Math.random() * 26);
                        break;
                    case 2:
                        b = 97 + (int) (Math.random() * 26);
                }
                baos.write(b);
            }
        }
        while (!baos.toString().matches("^(?=.*?[A-Za-z])(?=.*?[0-9]).{8}$"));

        return baos;
    }
}
