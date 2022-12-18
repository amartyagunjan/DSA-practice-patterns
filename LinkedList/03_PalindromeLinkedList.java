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
    public boolean isPalindrome(ListNode head) {
        // 1. reverse the linkedlist 
        // 2. Iterate through the linkedlist and 
        //    check if they contain the similar content.
        ListNode temp = head;
        ListNode mtemp = midNode(head);
        ListNode rtemp = reverse(mtemp);
        //boolean flag = true;

        while(rtemp != null){
            if(temp.val != rtemp.val){
                //flag = false;
                
                return false;
            }
            temp = temp.next;
            rtemp = rtemp.next;
        }

        return true;
    }
    
     public static ListNode midNode(ListNode head) {
    
        if(head == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    public static ListNode reverse(ListNode head){
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