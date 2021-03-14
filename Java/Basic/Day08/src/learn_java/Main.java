package learn_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter cells: ");
//        String str = scanner.nextLine();
//
//        System.out.println("---------");
//        System.out.println("| " + str.charAt(0) + " " + str.charAt(1) + " " + str.charAt(2) + " " + " |");
//        System.out.println("| " + str.charAt(3) + " " + str.charAt(4) + " " + str.charAt(5) + " " + " |");
//        System.out.println("| " + str.charAt(6) + " " + str.charAt(7) + " " + str.charAt(8) + " " + " |");
//        System.out.println("---------");

        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] arr2 = new int[arr.length];
        boolean isOrdered = false;

        for (int i = 0; i < arr.length; i++) {
            int num = 0;
            for (int j = 0; j < arr[i].length(); j++) {
                num += arr[i].charAt(j);
            }
            arr2[i] = num;
        }

        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] >= arr2[i - 1]) {
                isOrdered = true;
            } else {
                isOrdered = false;
                break;
            }
        }
        System.out.println(isOrdered);
    }
}
