package java_02;

import java.util.Arrays;

public class leetcode_1051 {
    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int nCount = 0;
        int[] otherArray = new int[n];

        for (int i = 0; i < n; i++) {
            otherArray[i] = heights[i];
        }

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (heights[j] < heights[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int t = heights[minIndex];
                heights[minIndex] = heights[i];
                heights[i] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            if (otherArray[i] != heights[i]) {
                nCount++;
            }
        }

        return nCount;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,4,2,1,3};
        int[] nums2 = {5,1,2,3,4};
        int[] nums3 = {1,2,3,4,5};
        int[] nums4 = {2,1,2,1,1,2,2,1};
        int[] nums5 = {};

        System.out.println(heightChecker(nums5));
    }

    public static void printArray(int i, int[] arr) {
        System.out.printf("%d: ", i);
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%d ", arr[j]);
        }
        System.out.println();
    }
}
