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
  
  public static void  addFirst(ListNode node){
      if(th == null){
          th = node;
          tt = node;
      }else{
          node.next = th;
          th = node;
      }
  }
    
    public ListNode reverseBetween(ListNode head, int n, int m) {
        if(head ==  null || head.next == null || n == m){
            return head;
        }
    
        ListNode prev = null, curr = head;
        int tempN = n;
        while(tempN-- > 1){
            prev = curr;
            curr = curr.next;
        }

        int count = m-n;
        while(count-- >= 0){
            //System.out.println(curr.val);
            ListNode forw = curr.next;
            addFirst(curr);
            curr = forw;
        }

        if(prev == null){
            head = th;
            tt.next = curr;
        }else{
            prev.next = th;
            tt.next = curr;
        }
        return head;
    }
}