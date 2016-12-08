package Test;


/**
 * Created by butkoav on 05.06.2016.
 */
public class Test17
{
    public static void main(String[] args) throws Exception
    {
        long t1 = System.currentTimeMillis();
        long d0 = 0;
        long d1 = 0;
        long d2 = 0;
        long d3 = 0;
        long d4 = 0;
        long d5 = 0;
        long d6 = 0;
        long d7 = 0;
        long d8 = 0;

        for (int i = 0; i < 100_000_000; i++)
        {
            d0 = d0 * d0;
            d1 = d1 * d1;
            d2 = d2 * d2;
         // d3 = d3 * d3;
        //  d4 = d4 * d4;
        }
        long t2 = System.currentTimeMillis();
        if(d1>0){}

        System.out.println(t2 - t1);


    }

}
