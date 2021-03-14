package learn_java;

import java.util.ArrayList;
import java.util.List;

public class Tung_442 {
    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(a));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();
        boolean[] isExist = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (isExist[nums[i]]) {
                result.add(nums[i]);
            } else {
                isExist[nums[i]] = true;
            }
        }
        return result;
    }
}
