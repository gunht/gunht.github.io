package LinkedList_02;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Tung_Leetcode_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode prev = head;
        ListNode temp = prev.next;

        int count = 0;
        while (temp != null) {
            if (temp == prev) {
                return true;
            }
            if (count == 2) {
                prev = prev.next;
                count = 0;
            }
            temp = temp.next;
            count++;
        }
        return false;
    }
}
