package learn_java;

import java.util.Arrays;

public class Leetcode_283 {
    public static void main(String[] args) {
        int[] a = {2,1,0,3};
        moveZeroes(a);
    }

    public static void moveZeroes(int[] nums) {
        int pointZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != pointZero && nums[pointZero] == 0) {
                int temp = nums[i];
                nums[i] = nums[pointZero];
                nums[pointZero++] = temp;
            } else if (nums[pointZero] != 0) {
                pointZero++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
