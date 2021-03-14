package java_01;

import java.util.Arrays;

public class Leetcode_283 {
    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12,0 ,2,3,4,5,3,0};
        int[] nums = {0,0,0,21,3,4,5,6,03,3,54,0,4,3,50};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
//        for (int j = 0; j < nums.length; j++) {
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i - 1] == 0) {
//                    int helper = nums[i - 1];
//                    nums[i - 1] = nums[i];
//                    nums[i] = helper;
//                }
//            }
//        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));

    }
}
