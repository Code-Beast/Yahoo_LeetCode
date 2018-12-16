/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ptr = head;
        int count = 0;
        while (ptr != null) {
            count ++;
            ptr = ptr.next;
        }
        
        return helper(head, count);
    }
    
    private ListNode helper(ListNode head, int length) {
        if (length == 1) return head;
        int count = length / 2;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        ListNode n = null;
        for (; count > 0; count --) {
            if (count == 1) {
                n = ptr2.next;
                ptr2.next = null;
                ptr2 = n;
            } else {
                ptr2 = ptr2.next;
            }
        }
        
        return mix(helper(ptr1, length / 2), helper(ptr2, length - length / 2));
    }
    
    private ListNode mix(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        head.next = head1.val < head2.val ? head1 : head2;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                ptr.next = head1;
                head1 = head1.next;
            } else {
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;
        }
        if (head1 == null) ptr.next = head2;
        else ptr.next = head1;
        return head.next;
    }
}

// Runtime: 5ms
// Time: O(nlogn)
// Space: O(1)
