package java_02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] str = input.split(" ");
            System.out.println(str[str.length - 1]);
        }

    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean isSorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    isSorted = false;
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
            printArray(i, a);
            if (isSorted) {
                break;
            }
        }
    }

    public static void selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (a[minIndex] < a[i]) {
                int t = a[minIndex];
                a[minIndex] = a[i];
                a[i] = t;
            }
            printArray(i, a);
        }
    }



    public static void printArray(int i, int[] arr) {
        System.out.printf("%d: ", i);
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%d ", arr[j]);
        }
        System.out.println();
    }
}
