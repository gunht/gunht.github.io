package Leetcode_394;

import java.util.Stack;

public class Tung_394 {
    public static void main(String[] args) {
//        String s = "10[a]2[bc]";
        String s = "3[a2[c]]";
//        String s = "2[abc]3[cd]ef";
//        String s = "abc3[cd]xyz";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<StringBuilder> string = new Stack<>();
        Stack<Integer> number = new Stack<>();

        string.push(new StringBuilder(""));
        int nTemp = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                nTemp = nTemp * 10 + c - '0';
            } else if (c == '[') {
                string.push(new StringBuilder(""));
                number.push(nTemp);
                nTemp = 0;
            } else if (c == ']') {
                String repeat = string.pop().toString().repeat(number.pop());
                string.peek().append(repeat);
            } else {
                string.peek().append(c);
            }
        }

        return string.pop().toString();
    }
}
