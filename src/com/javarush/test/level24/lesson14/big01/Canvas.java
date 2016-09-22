package com.javarush.test.level24.lesson14.big01;

/**
 * Created by butkoav on 22.09.2016.
 */
public class Canvas
{
    int width, height;
    char[][] matrix;

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public char[][] getMatrix()
    {
        return matrix;
    }

    public Canvas(int width, int height)
    {
        this.height = height;
        this.width = width;
        this.matrix = new char[height][width];
    }

    public void setPoint(double x, double y, char c)
    {
        int ix = (int) Math.round(x), iy = (int) Math.round(y);
        if (ix >= 0 && ix <= matrix[0].length & iy >= 0 && iy <= matrix.length)
            this.matrix[iy][ix] = c;
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] != 0) setPoint(x + j, y + i, c);

            }
        }
    }

    public void clear()
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                matrix[i][j] = ' ';
            }
        }
    }

    public void print()
    {
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.println(matrix[i]);
        }
        System.out.println();
        System.out.println();
    }
}
