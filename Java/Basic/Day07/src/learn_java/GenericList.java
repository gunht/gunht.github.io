package learn_java;

import java.util.Objects;

public class GenericList<T> {
    private int size;
    private T[] arr;
    private int counter;

    public GenericList(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
    }

    public void add(T item) {
        arr[counter++] = item;
    }

    public T get(int index) {
        return arr[index];
    }

    @Override
    public String toString() {
        String print = "";
        for (T item: arr) {
            print += item + "\t";
        }
        return print;
    }
}
