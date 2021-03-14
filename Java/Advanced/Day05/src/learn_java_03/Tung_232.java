package learn_java_03;

import java.util.ArrayList;

public class Tung_232 {
    private ArrayList<Integer> list;
    private int topIndex;

    /** Initialize your data structure here. */
    public Tung_232() {
        this.list = new ArrayList<>();
        this.topIndex = -1;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (list.isEmpty()) {
            topIndex++;
        }
        list.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        if (list.size() == 1) {
            return list.remove(topIndex--);
        }
        return list.remove(topIndex);
    }

    /** Get the front element. */
    public int peek() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(topIndex);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}
