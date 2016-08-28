package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k', 't'},
                {'u', 's', 'a', 'm', 'e', 'o', 'e'},
                {'l', 'n', 'g', 'r', 'o', 'v', 's'},
                {'m', 'l', 'p', 'r', 'r', 'h', 't'},
                {'p', 'o', 'e', 'e', 'j', 'j', 's'},
                {'p', 'o', 'e', 'e', 'j', 'j', 's'}
        };

        for (Word word : detectAllWords(crossword, "fderl"))
        {
            System.out.println(word);
        }

    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        List<Word> list = new ArrayList<>();

        for (int k = 0; k < words.length; k++)
        {
            for (int i = 0; i < crossword[0].length; i++)
            {
                for (int j = 0; j < crossword.length; j++)
                {
                    Word word = new Word(words[k]);
                    if (words[k].toLowerCase().toCharArray()[0] == crossword[j][i])
                    {
                        word.setStartPoint(i, j);
                        if (checkWord(crossword, i, j, words[k].toLowerCase(), word, 1, 0))
                        {
                            list.add(word);
                        }
                    }
                }
            }
        }
        return list;
    }

    private static boolean checkWord(int[][] crossword, int i, int j, String wrd, Word word, int s, int d)
    {
        int x = 0, y = 0;
        if (s == wrd.length())
        {
            word.setEndPoint(i, j);
            return true;
        }
        switch (d)
        {
            case 0:
                for (int k = 1; k <= 8; k++)
                {
                    if (checkWord(crossword, i, j, wrd, word, s, k)) return true;
                }
                break;
            case 1:
                y++;
                break;
            case 2:
                x++;
                y++;
                break;
            case 3:
                x++;
                break;
            case 4:
                x++;
                y--;
                break;
            case 5:
                y--;
                break;
            case 6:
                x--;
                y--;
                break;
            case 7:
                x--;
                break;
            case 8:
                x--;
                y++;
                break;
        }
        try
        {
            if (wrd.toCharArray()[s] == crossword[j + y][i + x])
            {
                if (checkWord(crossword, i + x, j + y, wrd, word, s + 1, d))
                {
                    return true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        return false;
    }


    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
