package learn_java_05;

public class Main {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(4);
        System.out.println("obj.enQueue: " + obj.enQueue(3));
        System.out.println("obj.Front: " + obj.Front());
        System.out.println("obj.isFull: " + obj.isFull());
        System.out.println("obj.enQueue: " + obj.enQueue(7));
        System.out.println("obj.enQueue: " + obj.enQueue(2));
        System.out.println("obj.enQueue: " + obj.enQueue(5));
        System.out.println("obj.deQueue: " + obj.deQueue());
        System.out.println("obj.enQueue: " + obj.enQueue(4));
        System.out.println("obj.enQueue: " + obj.enQueue(2));
        System.out.println("obj.isEmpty: " + obj.isEmpty());
        System.out.println("obj.Rear: " + obj.Rear());
    }
}