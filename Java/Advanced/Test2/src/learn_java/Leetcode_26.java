package learn_java;

import java.util.Arrays;

public class Leetcode_26 {
    public static void main(String[] args) {
        int[] nums = {1,1};
        int n = removeDuplicates(nums);
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int result = 1;
        int[] a = new int[n];
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            if (pointer == 0 && i == 0) {
                a[i] = nums[i];
            }
            if (a[pointer] != nums[i]) {
                pointer++;
                a[pointer] = nums[i];
                result++;
            }
        }
        for (int i = 0; i < result; i++) {
            nums[i] = a[i];
        }
        return result;
    }
}
