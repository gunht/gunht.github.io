package Leetcode_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (myMap.containsKey(k) && myMap.get(k) != i) {
                result[0] = i;
                result[1] = myMap.get(k);
                break;
            }
        }
        return result;
    }
}
