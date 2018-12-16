/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode headSmall = new ListNode(0);
        ListNode ptrSmall = headSmall;
        
        while (head != null && head.val < x) {
            ptrSmall.next = head;
            ptrSmall = ptrSmall.next;
            head = head.next;
        }
        ListNode ptr = head;
        if (ptr == null) return headSmall.next;
        ListNode pre = ptr;
        ptr = ptr.next;
        while (ptr != null) {
            if (ptr.val < x) {
                ptrSmall.next = ptr;
                ptrSmall = ptrSmall.next;
                pre.next = pre.next.next;
                ptr = ptr.next;
            } else {
                ptr = ptr.next;
                pre = pre.next;    
            }
        }
        
        ptrSmall.next = head;
        return headSmall.next;
    }
}

// Runtime: 1ms



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode headSmall = new ListNode(0);
        ListNode headBig = new ListNode(0);
        ListNode ptrSmall = headSmall;
        ListNode ptrBig = headBig;
        headBig.next = head;

        while (ptrBig.next != null) {
            if (ptrBig.next.val < x) {
                ptrSmall.next = ptrBig.next;
                ptrSmall = ptrSmall.next;
                ptrBig.next = ptrBig.next.next;
            } else {
                ptrBig = ptrBig.next;   
            }
        }
        
        ptrSmall.next = headBig.next;
        return headSmall.next;
    }
}

// Runtime: 0ms



class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preBig = null;

        if (head.val >= x) preBig = dummyHead;
        else {
            while (head.next != null && head.next.val < x) {
                head = head.next;
            }
            preBig = head;
            head = head.next;
        }
        
        if (head == null) return dummyHead.next;
        
        ListNode pre = head;
        ListNode ptr = head;
        ptr = ptr.next;
        while (ptr != null) {
            if (ptr.val < x) {
                preBig.next = ptr;
                pre.next = pre.next.next;
                preBig = preBig.next;
            } else {
                pre = pre.next;
            }
            ptr = ptr.next;
        }
        preBig.next = head;
        
        return dummyHead.next;
    }
}

// Runtime: 0ms
