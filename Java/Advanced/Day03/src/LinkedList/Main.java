package LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        LinkedList n1 = new LinkedList(1);
//        LinkedList n2 = new LinkedList(2);
//        LinkedList n3 = new LinkedList(3);
//
//        n1.next(n2);
//        n2.next(n3);
//
//        n1.printByRecurse(n1);

        MyLinkedList obj = new MyLinkedList();
//        int test = obj.get(1);
//        System.out.println(test);

        obj.addAtHead(1);
        obj.addAtTail(2);
//        obj.addAtIndex(-1, 3);
//        obj.deleteAtIndex(0);
        obj.print();
    }
}
