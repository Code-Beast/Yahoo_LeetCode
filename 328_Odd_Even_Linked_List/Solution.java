// Given a singly linked list, group all odd nodes together followed by the even nodes. 
// Please note here we are talking about the node number and not the value in the nodes.
// You should try to do it in place. 
// The program should run in O(1) space complexity and O(nodes) time complexity.

// Use a pointer record the end of odd list, so add a node to the end when it's odd.

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ptrOdd = head;
        ListNode ptrEven = head.next;
        ListNode evenHead = ptrEven;
        
        while (ptrEven != null && ptrEven.next != null) {
            ptrOdd = ptrOdd.next = ptrEven.next;
            ptrEven = ptrEven.next = ptrOdd.next;
        }
        
        ptrOdd.next = evenHead;
        return head;
    }
}

// Runtime: 4ms



