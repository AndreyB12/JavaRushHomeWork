package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        byte[][] a = new byte[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1},
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");

    }

    public static int getRectangleCount(byte[][] a)
    {
        int count = 0;
        int n = a.length;
        byte[][] c = new byte[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (a[i][j] == 1 && c[i][j] == 0)
                {
                    count++;
                    markRectangle(i, j, a, c);
                }
                c[i][j] = 1;

            }
        }
        return count;
    }

    private static void markRectangle(int i, int j, byte[][] a, byte[][] c)
    {
        if (i + 1 < a.length)
        {
            if (a[i + 1][j] == 1)
            {

                markRectangle(i + 1, j, a, c);
            }
            c[i + 1][j] = 1;
        }
        if (j + 1 < a.length)
        {
            if (a[i][j + 1] == 1)
            {

                markRectangle(i, j + 1, a, c);
            }
            c[i][j + 1] = 1;
        }
    }
}
