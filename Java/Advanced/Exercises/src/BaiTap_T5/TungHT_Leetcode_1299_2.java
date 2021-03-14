package BaiTap_T5;

import java.util.Arrays;

public class TungHT_Leetcode_1299_2 {
    public static void main(String[] args) {
        int[] a = {17,18,5,4,6,1};
//        int[] a = {17,18,5,4,6};
//        int[] a = {17,18,5,4};
//        int[] a = {17,18,5};
//        int[] a = {17,18};
//        int[] a = {17};
        System.out.println(Arrays.toString(replaceElements(a)));

    }

    public static int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];
        a[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            a[i] = checkTwoNum(a, arr, i);
        }
        return a;
    }
    public static int checkTwoNum(int[] a, int[] arr, int i) {
        int max = 0;
        if (a[i + 1] > arr[i + 1]) {
            max = a[i + 1];
        } else {
            max = arr[i + 1];
        }
        return max;
    }
}
