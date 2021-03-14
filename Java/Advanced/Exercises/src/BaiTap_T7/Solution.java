package BaiTap_T7;

public class Solution {
    int[] newArr = new int[46];

    public int climbStairs(int n) {
        if (n <= 2){
            newArr[1] = 1;
            newArr[2] = 2;
            return n;
        }
        if (newArr[n] != 0){
            return newArr[n];
        }

        newArr[n] = climbStairs(n-1) + climbStairs(n-2);
        return newArr[n];
    }
}
