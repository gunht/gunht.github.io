package learn_java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here\
//        Scanner scanner = new Scanner(System.in);
//
//        String[] str = new String[2];
//        for (int i = 0; i < 2; i++) {
//            str[i] = scanner.nextLine();
//        }
//
//        for (int i = 0; i < str.length; i++) {
//            System.out.println(str[i].replace("a", "b"));
//            System.out.println();
//        }

        boolean b1 = true;
        boolean b2 = true;

        System.out.println(b1 || !!b2);
        System.out.println(!b1 || b2);
        System.out.println(!b1 && b2);
        System.out.println(!(b1 || b2));
        System.out.println(!b1 && !b2);
    }
}
