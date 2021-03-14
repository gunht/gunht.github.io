package java_03;

import java.util.Arrays;

public class leetcode_344 {
    public static void main(String[] args) {
        char[] char1 = {'h', 'e', 'l', 'l', 'o'};
        char[] char2 = {'H', 'a', 'n', 'n', 'a', 'h'};

        reverseString(char1, 0);
//        reverseString(char1);
    }

    public static void reverseString(char[] s, int i) {
        if (i < s.length / 2) {
            char t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = t;
            reverseString(s, i + 1);
        } else {
            System.out.println(Arrays.toString(s));
        }
    }

    public static void reverseString(char[] s) {
        for (int j = 0; j < s.length / 2; j++) {
            char t = s[j];
            s[j] = s[s.length - 1 - j];
            s[s.length - 1 - j] = t;
        }
    }
}
