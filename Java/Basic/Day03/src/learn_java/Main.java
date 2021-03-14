package learn_java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s1 = " Welcome ";
        String s2 = " welcome ";
        //a
        Boolean compare1 = s1.equals(s2);
        //b
        Boolean compare2 = s1.equalsIgnoreCase(s2);
        //c
        int compare3 = s1.compareTo(s2);
        //d
        int compare4 = s1.compareToIgnoreCase(s2);
        //e
        compare2 = s1.startsWith("AAA");
        //f
        compare2 = s1.endsWith("AAA");
        //g
        int length = s1.length();
        //h
        char c = s1.charAt(0);
        //i
        String s3 = s1 + s2;
        //j
        String sub1 = s1.substring(1);
        //k
        String sub2 = s1.substring(1, 4);
        //l
        s3 = s1.toLowerCase();
        //m
        s3 = s1.toUpperCase();
        //n
        s2 = s1.trim();
        //o
        int firstChar = s1.indexOf("e");
        //p
        int lastIndex = s1.lastIndexOf("abc");


        System.out.println(firstChar);
    }
}
