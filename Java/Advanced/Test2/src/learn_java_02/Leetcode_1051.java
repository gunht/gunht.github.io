package learn_java_02;

import java.util.Arrays;

public class Leetcode_1051 {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int result = 0;
        int n = heights.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = heights[i];
        }
        selectSort(a);
        for (int i = 0; i < n; i++) {
            if (a[i] != heights[i]) {
                result++;
            }
        }
        return result;
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
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
