// leetcode q_no: 237

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode forw = node.next;
        node.val = forw.val;
        node.next = forw.next;
        forw.next = null;
    }
}