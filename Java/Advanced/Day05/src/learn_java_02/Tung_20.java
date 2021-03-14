package learn_java_02;

import java.util.Arrays;
import java.util.Stack;

public class Tung_20 {
    public static void main(String[] args) {
//        System.out.println(isValid("}"));
        ;
        boolean valid = checkString("{{}[](}");
        System.out.println(valid);

    }

    public static boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();

//        char[] arr = s.toCharArray();

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
//                myStack.push(arr[i]);
//            } else {
//                if (myStack.isEmpty()) {
//                    return false;
//                }
//                if (arr[i] == '}') {
//                    String temp = myStack.peek() + "" + arr[i];
//                    if (temp.equals("{}")) {
//                        myStack.pop();
//                    } else {
//                        return false;
//                    }
//                } else if (arr[i] == ']') {
//                    String temp = myStack.peek() + "" + arr[i];
//                    if (temp.equals("[]")) {
//                        myStack.pop();
//                    } else {
//                        return false;
//                    }
//                } else {
//                    String temp = myStack.peek() + "" + arr[i];
//                    if (temp.equals("()")) {
//                        myStack.pop();
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }

        if (!(myStack.isEmpty())) {
            return false;
        }

        return true;
    }

    public static boolean checkString(String s) {
        Stack<Character> myStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                myStack.push(c);
            } else {
                if (myStack.isEmpty()) {
                    return false;
                }
                if (c == '}' && myStack.peek() == '{') {
                    myStack.pop();
                } else if (c == ']' && myStack.peek() == '[') {
                    myStack.pop();
                } else if (c == ')' && myStack.peek() == '(') {
                    myStack.pop();
                } else {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }
}
