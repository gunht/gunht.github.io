package java_01;

public class Leetcode_26 {
    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {0,0,0,0,1,1,1,2,2,3,3,4,4,5,5,5,6,6,6,6};
//        int[] nums = {1,1,2};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
