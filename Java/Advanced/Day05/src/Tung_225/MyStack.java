package Tung_225;

import java.util.ArrayList;

public class MyStack {
    private ArrayList<Integer> list;
    private int topIndex;

    /** Initialize your data structure here. */
    public MyStack() {
        this.list = new ArrayList<>();
        this.topIndex = -1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
        topIndex++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(topIndex--);
    }

    /** Get the top element. */
    public int top() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(topIndex);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}
