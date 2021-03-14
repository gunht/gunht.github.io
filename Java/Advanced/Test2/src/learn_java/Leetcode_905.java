package learn_java;

import java.util.Arrays;

public class Leetcode_905 {
    public static void main(String[] args) {
        int[] a = {1,8,3,6,2,9,5,4};
        System.out.println(Arrays.toString(sortArrayByParity(a)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] a = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                a[left++] = A[i];
            } else {
                a[right--] = A[i];
            }
        }
        return a;
    }
}
