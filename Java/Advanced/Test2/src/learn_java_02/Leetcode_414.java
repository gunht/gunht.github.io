package learn_java_02;

import java.util.Arrays;

public class Leetcode_414 {
    public static void main(String[] args) {
//        int[] nums = {1,2,2,5,3,5};
//        int[] nums = {1,2,-2147483648};
        int[] nums = {1,-2147483648,2};
//        int[] nums = {3,3,4,3,4,3,0,3,3};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        int n = nums.length;
        int[] a = new int[3];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > a[2] || count == 0) {
                a[0] = a[1];
                a[1] = a[2];
                a[2] = nums[i];
                count++;
            } else if ((nums[i] > a[1] || count == 1) && nums[i] != a[2]) {
                a[0] = a[1];
                a[1] = nums[i];
                count++;
            } else if ((nums[i] > a[0] || count == 2) && nums[i] != a[1] && nums[i] != a[2]) {
                a[0] = nums[i];
                count++;
            }
        }
        if (count < 3) {
            return a[2];
        }
        return a[0];
    }
}
