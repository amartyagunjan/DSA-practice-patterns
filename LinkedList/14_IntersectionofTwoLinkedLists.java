// Leetcode q_no : 160

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public int length(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = length(headA);
        int lenB = length(headB);
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++){
                    tempA = tempA.next;
            }
        }
        else{
            for(int i = 0; i < lenB - lenA; i++){
                tempB = tempB.next;
            }
        }
        
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        
        return tempA;
    }
}