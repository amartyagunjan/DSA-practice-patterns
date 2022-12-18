import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode temp = head;
        ListNode even = new ListNode(0);
        ListNode odd = new ListNode(0);
        ListNode evenTemp = even;
        ListNode oddTemp = odd;

        while(temp != null){
            if(temp.val % 2 == 0){
                evenTemp.next = temp;
                evenTemp = evenTemp.next;
            }
            else{
                oddTemp.next = temp;
                oddTemp = oddTemp.next;
            }
            temp = temp.next;
        }
        oddTemp.next = null;
        evenTemp.next = odd.next;
        return even.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}