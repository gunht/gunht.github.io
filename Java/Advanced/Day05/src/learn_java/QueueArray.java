package learn_java;

public class QueueArray implements IQueue {
    private int[] arr;
    private int SIZE;
    private int headIndex, tailIndex;

    public QueueArray(int size) {
        this.arr = new int[SIZE];
        headIndex = tailIndex = -1;
    }

    @Override
    public void push() {

    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
