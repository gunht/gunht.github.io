package BaiTap_T3;

import java.util.Arrays;

public class TungHT_Leetcode_1295 {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int[] nums2 = {555,901,482,1771};

        System.out.println(findNumbers(nums));
        System.out.println(findNumbers(nums2));
    }

    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int i : nums) {
            int length = String.valueOf(i).length();
            if (length % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
