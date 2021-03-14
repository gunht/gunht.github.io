package learn_java;

import java.util.Arrays;

public class Leetcode_27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int result = removeElement(nums, 2);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int result = 0;
        int pointer = 0;
        int[] a = nums;
        for (int i = 0; i < n; i++) {
            if (a[i] != val) {
                nums[pointer++] = a[i];
                result++;
            }
        }
        return result;
    }
}
