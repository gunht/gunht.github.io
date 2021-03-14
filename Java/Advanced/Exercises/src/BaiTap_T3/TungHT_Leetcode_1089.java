package BaiTap_T3;

import java.util.Arrays;

public class TungHT_Leetcode_1089 {
    public static void main(String[] args) {
        int[] a = {1,0,2,3,4,5,0,7};
        int[] b = {1,0,2};
        int[] c = {1,2,0};
        int[] d = {1,2,3};
        duplicateZeros(a);
    }

    public static void duplicateZeros(int[] arr) {
        for (int i= 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 2; j > i; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }
}
