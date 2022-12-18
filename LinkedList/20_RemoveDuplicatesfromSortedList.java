// leetcode q_no 83

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        while(curr.next != null){
            ListNode forw = curr.next;
            if(forw.val == curr.val){
                curr.next = forw.next;
            }
            else{
                curr = forw;
            }
        }
        return head;
    }
}