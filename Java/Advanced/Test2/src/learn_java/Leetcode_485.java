package learn_java;

public class Leetcode_485 {
    public static void main(String[] args) {
        int[] a = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(a));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > result) {
                    result = count;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
        int[] a = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;
            } else {
                a[j]++;
            }
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > result) {
                result = a[i];
            }
        }
        return result;
    }
}
