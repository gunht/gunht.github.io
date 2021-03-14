package learn_java;

public class StackArray implements IStack{
    private int SIZE;
    private int[] arr;
    private int topIndex;

    public StackArray(int size) {
        this.arr = new int[SIZE];
        this.topIndex = -1;
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
