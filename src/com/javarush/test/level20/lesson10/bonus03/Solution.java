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

        for (Word word : detectAllWords(crossword, "er"))
        {
            System.out.println(word);
        }

    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        List<Word> list = new ArrayList<>();

        for (int k = 0; k < words.length; k++)
        {
            for (int j = 0; j < crossword.length; j++)
            {
                for (int i = 0; i < crossword[0].length; i++)
                {
                    if (words[k].toLowerCase().toCharArray()[0] == crossword[j][i])
                    {
                        checkWord(crossword, i, j, 1, 0, words[k].toLowerCase(), list);
                        checkWord(crossword, i, j, 1, 1, words[k].toLowerCase(), list);
                        checkWord(crossword, i, j, 0, 1, words[k].toLowerCase(), list);
                        checkWord(crossword, i, j, -1, 1, words[k].toLowerCase(), list);
                        checkWord(crossword, i, j, -1, 0, words[k].toLowerCase(), list);
                        checkWord(crossword, i, j, -1, -1, words[k].toLowerCase(), list);
                        checkWord(crossword, i, j, 0, -1, words[k].toLowerCase(), list);
                        checkWord(crossword, i, j, 1, -1, words[k].toLowerCase(), list);
                    }
                }
            }
        }
        return list;
    }

    private static void checkWord(int[][] crossword, int strtX, int strtY, int dx, int dy, String word, List<Word> list)
    {
        boolean finded = true;
        int i;
        for (i = 1; i < word.length(); i++)
        {
            try
            {
                if (crossword[strtY + dy * i][strtX + dx * i] != word.toCharArray()[i])
                {
                    finded = false;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                finded = false;
            }
        }
        if (finded)
        {
            Word wrd = new Word(word);
            wrd.setStartPoint(strtX, strtY);
            wrd.setEndPoint(strtX + dx * (i - 1), strtY + dy * (i - 1));
            list.add(wrd);
        }
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
