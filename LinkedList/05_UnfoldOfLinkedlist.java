
import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode head1 = head;
        ListNode head2 = head.next;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp2 != null && temp2.next != null){
            temp1.next = temp2.next;
            temp1 = temp1.next;
            temp2.next = temp1.next;
            temp2 = temp2.next;
        }
        head2 = reverse(head2);
        temp1.next = head2;
               
        head = head1;

    }

    static ListNode reverse(ListNode head){
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

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}