package learn_java;

import java.util.Arrays;

public class Leetcode_1089 {
    public static void main(String[] args) {
        int[] arr = {1};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];

        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] != 0) {
                a[j] = arr[i];
                i++; j++;
            } else {
                i++; j+= 2;
            }
        }

        for (int k = 0; k < n; k++) {
            arr[k] = a[k];
        }
    }
}
