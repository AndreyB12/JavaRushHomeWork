package Test;

/**
 * Created by butkoav on 14.12.2016.
 */
public class MathSpeedTest
{
    public static void main(String... args)
    {
        long start = System.currentTimeMillis();
        int d0 = 0;
        int d1 = 0;

        for (int i = 0; i < 100_000_000; i++)
        {
            d0 = d0 * d0;
            d1 = d0 * d0;
        }
        if (d0 > 0 || d1 > 0)
        {
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
