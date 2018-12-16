/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        helper(head, dummyHead).next = null;
        
        return dummyHead.next;   
    }
    
    private ListNode helper(ListNode rest, ListNode head) {
        if (rest.next == null) {
            head.next = rest;
            return rest;
        }
        
        helper(rest.next, head).next = rest;
        return rest;
    }
}

// Runtime: 0ms
// Time: O(n)
// Space: O(n)



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode rest = head;
        
        while (rest.next != null) {
            ListNode curr = rest.next;
            rest.next = curr.next;
            curr.next = head;
            head = curr;
        }
        
        return head;
    }
}

// Runtime: 0ms
// Time: O(n)
// Space: O(1)
