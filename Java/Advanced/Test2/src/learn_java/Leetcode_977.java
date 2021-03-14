package learn_java;

import java.util.Arrays;

public class Leetcode_977 {
    public static void main(String[] args) {
        int[] a = {-4, 2};
        System.out.println(Arrays.toString(sortedSquares(a)));
    }

    public static int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = (int)Math.pow(A[i], 2);
        }
        int i1 = 0, j1 = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i1] <= A[j1]) {
                arr[i] = A[j1--];
            } else {
                arr[i] = A[i1++];
            }
        }
        return arr;
    }
}
