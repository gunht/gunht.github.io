package learn_java_05;

public class MyCircularQueue {
    private int[] arr;
    private int SIZE;
    private int headIndex, tailIndex;

    public MyCircularQueue(int size) {
        this.SIZE = size;
        this.arr = new int[SIZE];
        this.headIndex = this.tailIndex = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            headIndex++;
        }
        if (headIndex > 0 && tailIndex >= SIZE - 1) {
            tailIndex = -1;
        }
        tailIndex++;
        arr[tailIndex] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (tailIndex == headIndex) {
            headIndex = tailIndex = -1;
            return true;
        }
        if (headIndex >= SIZE - 1) {
            headIndex = 0;
            return true;
        }
        headIndex++;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[headIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[tailIndex];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (headIndex < 0) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (headIndex == 0 && tailIndex >= SIZE - 1) {
            return true;
        }
        if (headIndex > 0 && headIndex - tailIndex == 1) {
            return true;
        }
        return false;
    }
}
