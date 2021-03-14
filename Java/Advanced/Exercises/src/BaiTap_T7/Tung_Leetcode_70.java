package BaiTap_T7;

public class Tung_Leetcode_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int[] arr = new int[46];

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        arr[n] = climbStairs(n - 2) + climbStairs(n - 1);
        return arr[n];
    }
}
