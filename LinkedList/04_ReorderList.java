// Leetcode q no - 143 Solution

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
    public void reorderList(ListNode head) {
        // 1. get middle of linked list.
        // 2. reverse the linkedlist starting with middle node.
        // 3. Iterate throught the two linkedlists we have and arrange.
        if(head == null || head.next == null){
            return;
        }
        ListNode midHead = middle(head);
        ListNode reverseMiddleHead = reverse(midHead);
        ListNode tempP1 = head;
        ListNode tempP2 = reverseMiddleHead;
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while(tempP1 != null && tempP2 != null){
            System.out.println("hello");
            temp.next = tempP1;
            tempP1 = tempP1.next;
            temp = temp.next;
            temp.next = tempP2;
            tempP2 = tempP2.next;
            temp = temp.next;
        }
        
        if(tempP1 != null){
            temp.next = tempP1;
        }
        
        if(tempP2 != null){
            temp.next = tempP2;
        }
        head =  newHead.next;
        
    }
    
    public ListNode middle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode ptemp = null;
        ListNode temp = head;
        ListNode ntemp = head.next;
        
        while(temp != null){
            temp.next = ptemp;
            ptemp = temp;
            temp = ntemp;
            if(ntemp != null){
                ntemp = ntemp.next;
            }
        }
        
        return ptemp;
    }
}
