package learn_java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Bai_03 {

    public static void main(String[] args) {
	// write your code here
        String s = "Pp";
//        String s = "abBAcC";
//        String s = "leEeetcode";
//        String s = "mC";
//        String s = "RLlr";
//        String s = "WAuUaw";

        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                if (!stack.isEmpty() && stack.peek() == s.charAt(i) + 32) {
                    stack.pop();
                } else if ((i + 1) < s.length() && s.charAt(i + 1) == s.charAt(i) + 32) {
                    i++;
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                if (!stack.isEmpty() && stack.peek() == s.charAt(i) - 32) {
                    stack.pop();
                } else if ((i + 1) < s.length() && s.charAt(i + 1) == s.charAt(i) - 32) {
                    i++;
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
