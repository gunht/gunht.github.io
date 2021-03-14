package learn_java;

import java.util.Stack;

public class Tung_844 {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";


        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        String s = "";
        String t = "";
        for (char c : S.toCharArray()) {
            if (c == '#' && !stack1.isEmpty()) {
                stack1.pop();
                continue;
            }
            if (c != '#') {
                stack1.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#' && !stack2.isEmpty()) {
                stack2.pop();
                continue;
            }
            if (c != '#') {
                stack2.push(c);
            }
        }
        while (!stack1.isEmpty()) {
            s = stack1.pop() + s;
        }
        while (!stack2.isEmpty()) {
            t = stack2.pop() + t;
        }
        return s.equals(t);
    }
}
