package com.THR.’˝‘Ú;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ∆•≈‰Matcher
 *
 * @author Thr
 */
public class FindTest {

    public static void main(String args[]){
        checkValueXssReplace();
    }


    public static void checkValueXssReplace() {
        String str = "yyy1122";
        Pattern pattern = Pattern.compile("yyy\\d+",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
    }


}
