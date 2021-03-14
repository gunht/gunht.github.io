package BaiTap_T4;

import java.util.Arrays;

public class TungHT_Leetcode_27 {
    public static void main(String[] args) {
        int[] a = {3,2,2,3};
        int[] b = {0,1,2,2,3,0,4,2};
        int[] c = {2,2,3};
        int len = removeElement(c, 3);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(c[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int[] a = new int[nums.length];
        int nCount = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                a[j++] = nums[i];
                nCount++;
            }
        }
        for (int i = 0; i < nCount; i++) {
            nums[i] = a[i];
        }
        return nCount;
    }
}
