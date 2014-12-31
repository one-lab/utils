package org.onelab.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Created by chunliangh on 14-12-9.
 */
public class Demo {
    public static void main(String[] args){
        String[] name = new String[]{"s"};
        String[] arg = Arrays.copyOf(name, name.length - 1);
        System.out.println("args size:"+arg.length);
        for (String arr:arg){
            System.out.println(arr);
        }
        System.out.println("end");
    }
}