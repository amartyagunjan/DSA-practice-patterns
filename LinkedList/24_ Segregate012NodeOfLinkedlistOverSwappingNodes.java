import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode zero = new ListNode(-1), prevZ = zero;
        ListNode one = new ListNode(-1), prevO = one;
        ListNode two = new ListNode(-1), prevT = two;

        ListNode curr  = head;

        while(curr != null){
            if(curr.val == 0){
                prevZ.next = curr;
                prevZ = prevZ.next;
            }
            else if(curr.val == 1){
                prevO.next = curr;
                prevO = prevO.next;
            }
            else{
                prevT.next = curr;
                prevT = prevT.next;
            }
            curr = curr.next;
        }

        prevT.next = null;
        prevO.next = two.next;
        prevZ.next = one.next;

        // prevZ.next = one.next;
        // prevO.next = two.next;
        // prevT.next = null;
        return zero.next;

    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate012(h1);
        printList(h1);
    }
}