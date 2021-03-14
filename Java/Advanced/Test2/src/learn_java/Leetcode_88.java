package learn_java;

import java.util.Arrays;

public class Leetcode_88 {
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};

        merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int length = m + n;
        int[] a = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n || k < length) {
            if (i < m && j < nums2.length && nums1[i] <= nums2[j]) {
                a[k++] = nums1[i++];
            } else if (i < m && j >= n) {
                a[k++] = nums1[i++];
            } else {
                a[k++] = nums2[j++];
            }
        }
        for (int l = 0; l < length; l++) {
            nums1[l] = a[l];
        }
    }
}
