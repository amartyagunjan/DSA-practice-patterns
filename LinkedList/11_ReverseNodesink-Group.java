// leetcode q_no: 25


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

    static ListNode th = null, tt = null;
    
    public void addFirst(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k== 0){
            return head;
        }
        
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        ListNode oh = null, ot = null, curr = head;
        while(len >= k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode forw = curr.next;
                //curr.next = null;
                addFirst(curr);
                curr = forw;
                //forw = forw.next;
            }
            
            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }
            
            th = null;
            tt = null;
            len = len - k;
        }
        
        ot.next = curr;
        return oh;
    }
    
}