package Leetcode_202;

import java.util.HashSet;
import java.util.Set;

public class Tung_202 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            if (set.contains(sum) || sum == 1) {
                n = sum;
                break;
            }
            set.add(sum);
            n = sum;
        }
        if (set.contains(n)) {
            return false;
        }
        return true;
    }
}
