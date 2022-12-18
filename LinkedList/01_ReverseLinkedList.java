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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode tempPrev = null;
        ListNode tempNext = head.next;
        
        while(temp != null){
            temp.next = tempPrev;
            tempPrev = temp;
            temp = tempNext;
            if(tempNext != null){
                tempNext = tempNext.next;
            }
        }

        return tempPrev;
    }
}