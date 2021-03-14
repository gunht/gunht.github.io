package learn_java;

import java.util.Arrays;

public class Leetcode_1299 {
    public static void main(String[] args) {
        int[] a = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(a)));
    }

    public static int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];
        a[n - 1] = -1;
        int pointer = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[pointer] > a[pointer]) {
                a[i] = arr[pointer--];
            } else {
                a[i] = a[pointer--];
            }
        }
        return a;
    }
}
