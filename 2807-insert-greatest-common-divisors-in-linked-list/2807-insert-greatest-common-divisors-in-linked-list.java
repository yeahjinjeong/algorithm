/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        insertListNode(head);
        return head;
    }

    public static void insertListNode(ListNode head) {
        if (head.next != null) {
            int mid = 1;
            for (int i = 1; i <= Math.max(head.val, head.next.val); i++) {
                if (head.val % i == 0 && head.next.val % i == 0) {
                    mid = i;
                }
            }
            head.next = new ListNode(mid, head.next);
            insertListNode(head.next.next);
        }
    }
}