package Leetcode_349;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
//        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
//        int[] nums1 = {}, nums2 = {1, 1};
        int[] nums1 = {4,7,9,7,6,7}, nums2 = {5,0,0,6,1,6,2,2,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        Set<Integer> results = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }
        for (int num : nums2) {
            nums2Set.add(num);
        }
        for (int num : nums2Set) {
            if (nums1Set.contains(num)) {
                results.add(num);
            }
        }
        int[] result = new int[results.size()];
        int i = 0;
        for (int num : results) {
            result[i++] = num;
        }
        return result;
    }
}
