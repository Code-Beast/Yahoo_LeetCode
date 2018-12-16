/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode ptr = dummyHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            
            ptr = ptr.next;
        }
            
        ptr.next = l1 == null ? l2 : l1;
    
        return dummyHead.next;
    }
}

// Runtime: 9ms
// Time: O(m+n)
// Space: O(1)
