package BaiTap_T5;

import java.util.Arrays;

public class TungHT_Leetcode_1299 {
    public static void main(String[] args) {
//        int[] a = {17,18,5,4,6,1};
//        int[] a = {17,18,5,4,6};
//        int[] a = {17,18,5,4};
//        int[] a = {17,18,5};
//        int[] a = {17,18};
        int[] a = {17};
        System.out.println(Arrays.toString(replaceElements(a)));
    }

    public static int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = findNum(arr, i);
            if (i + 1 == n - 1) {
                arr[n - 1] = -1;
            }
        }
        return arr;
    }

    public static int findNum(int[] a, int x) {
        int maxNum = 0;
        for (int i = x + 1; i < a.length; i++) {
            if (a[i] > maxNum) {
                maxNum = a[i];
            }
        }
        return maxNum;
    }
}
