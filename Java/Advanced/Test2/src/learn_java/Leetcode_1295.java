package learn_java;

public class Leetcode_1295 {
    public static void main(String[] args) {
        int[] a = {345};
        System.out.println(findNumbers(a));
    }

    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int n = String.valueOf(num).length();
            if (n % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
