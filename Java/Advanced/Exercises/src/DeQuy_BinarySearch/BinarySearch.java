package DeQuy_BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] nums = {-1,0,2,3,5,9,12};
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int L, int R, int x) {
        if (L > R)
            return -1;

        int k = (L + R) /2;

        if (x == nums[k])
            return k;

        if (x < nums[k])
            return binarySearch(nums, L, k - 1, x);

        return binarySearch(nums, k + 1, R, x);
    }
}
