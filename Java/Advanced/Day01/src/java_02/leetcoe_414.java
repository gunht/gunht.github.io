package java_02;

import javax.swing.*;
import java.util.Arrays;

public class leetcoe_414 {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {2, 2, 1, 3, 2, 1, 3, 5};
        int[] nums3 = {2, 1};
        int[] nums4 = {3, 2, 1, 7, 6, 5, 5, 7, 9};
        int[] nums5 = {7, 2, 5};
        int[] nums6 = {1, 1, 2};
        int[] nums7 = {5,2,2};

        System.out.println(thirdMax(nums7));
    }

    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        if (nums.length == 1) { return nums[0]; }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[0];
            } else {
                return nums[1];
            }
        }
        int[] nArr = new int[3];
        int nCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nArr[0] || nCount == 0) {
                nArr[2] = nArr[1];
                nArr[1] = nArr[0];
                nArr[0] = nums[i];
                nCount++;
            } else if ((nums[i] > nArr[1] || nCount == 1) && nums[i] != nArr[0]) {
                nArr[2] = nArr[1];
                nArr[1] = nums[i];
                nCount++;
            } else if ((nums[i] > nArr[2] || nCount == 2) && nums[i] != nArr[0] && nums[i] != nArr[1]) {
                nArr[2] = nums[i];
                nCount++;
            }
        }
        return nCount > 2 ? nArr[2] : nArr[0];
    }
}
