package learn_java;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_448 {
    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(a));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] a = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
