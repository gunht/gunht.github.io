package java_01;

import java.util.Arrays;

public class Leetcode_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < n + m; i++) {
            nums1[i] = nums2[i - m];
        }
        for (int j = 0; j < nums1.length; j++) {
            for (int i = 1; i < nums1.length; i++) {
                if (nums1[i] < nums1[i - 1]) {
                    int helper = nums1[i];
                    nums1[i] = nums1[i - 1];
                    nums1[i-1] = helper;
                }
            }
        }

        System.out.print(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
	// write your code here
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1, 3, nums2, 3);
    }
}
