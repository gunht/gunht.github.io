package DeQuy;

import java.util.Arrays;

public class Leetcode_344 {
    public static void main(String[] args) {
        char[] c = {'h','e','l','l','o'};
        reverseString(c);
        System.out.println(Arrays.toString(c));
    }

    public static void reverseString(char[] s) {
        recursion(s, 0);
    }

    public static void recursion(char[] c, int i) {
        if (i > c.length) {
            return;
        }
        
    }
}
