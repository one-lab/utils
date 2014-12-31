package org.onelab.utils.longs;

import java.util.Calendar;

/**
 * Created by chunliangh on 14-12-17.
 */
public class NanoTime {
    public static void main(String[] args){
//        long val = System.nanoTime();
//        System.out.println(val);//5:14
//        System.out.println((807647607642000l-8l*3600l*1000*1000*10000)%(3600l*1000*1000*10000));//5:14   14
//        System.out.println((15647607642000l)/(60l*1000*1000*10000));//5:14  26
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2011,6,28);
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.set(2014,11,17);
//        System.out.println((calendar1.getTimeInMillis()-calendar.getTimeInMillis())/3600000/24);
//        System.out.println(Math.abs(-14%20));
        for (int i=0;i<10;i++){
            int index = (int)System.currentTimeMillis()%20;
            System.out.println(index);
        }
        for (int i=0;i<1000;i++){
            int index = (int)(System.currentTimeMillis()%20);
            System.out.print(index);
            System.out.print(" ");
        }
    }
}
