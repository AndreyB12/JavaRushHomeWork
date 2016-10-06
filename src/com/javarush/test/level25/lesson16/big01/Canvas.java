package com.javarush.test.level25.lesson16.big01;

/**
 * Created by butkoav on 06.10.2016.
 */
public class Canvas
{
    int width, height;
    char[][] matrix;

    public Canvas(int width, int height)
    {
        this.width = width;
        this.height = height;

        matrix = new char[height][width];
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public char[][] getMatrix()
    {
        return matrix;
    }

    public void setPoint(double x, double y, char c)
    {
        if (x < 0 || y < 0 || x > matrix[0].length || y > matrix.length) return;
        matrix[(int) Math.round(y)][(int) Math.round(x)] = c;

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
