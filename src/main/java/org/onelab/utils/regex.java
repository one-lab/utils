package org.onelab.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chunliangh on 14-12-31.
 */
public class regex {
    public static void main(String[] args){
        Pattern pattern = Pattern.compile("assass");
        Matcher matcher = pattern.matcher("sssss");
        System.out.println(matcher.matches());
        matcher = pattern.matcher("assass");
        System.out.println(matcher.matches());
        matcher = pattern.matcher("assasssd");
        System.out.println(matcher.matches());
    }

}
