package com.example.pattern;

import javax.sound.midi.Soundbank;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunhu
 * @date 2020/12/22 13:43
 */
public class PatternDemo {

    public static void main(String[] args) {

        String str="qwerTyuiop";

        String m = str.replaceAll("[^qwer]", "m");
        System.out.println(m);

        m=str.replaceAll("[A-Z]","*");
        System.out.println(m);


        m=str.replaceAll("(?<=\\w{3})\\w(?=\\w{4})","*");
        System.out.println(m);
    }
}
