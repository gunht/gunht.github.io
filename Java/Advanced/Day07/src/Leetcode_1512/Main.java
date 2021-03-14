package Leetcode_1512;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        int[] arr = {1,2,3,1,1,3};
//        int[] arr = {1,1,1,1};
        int[] arr = {1,2,3};
        System.out.println(numIdenticalPairs(arr));
    }

    public static int numIdenticalPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    result++;
                }
            }
        }
        return result;
    }
}
