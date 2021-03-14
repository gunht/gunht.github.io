package LinkedList_03;

public class Tung_Leetcode_206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            if (head.next == null) {
                System.out.println("null");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // write your code here
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;

        print(a1);
        ListNode newList = reverseList(a1);
        print(newList);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            ListNode forward = cur.next;
            cur.next = forward.next;
            forward.next = head;
            head = forward;
        }
        return head;
    }
}
