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

    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = middle(head);

        head1 = mergeSort(head1);
        head2 = mergeSort(head2);

        return mergeTwoLists(head1, head2);
        

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }

        if(l1 != null){
            temp.next = l1;
        }
        else{
            temp.next = l2;
        }

        return head.next;
    }

    public static ListNode middle(ListNode head){
        if(head == null || head.next == null){
            return head; 
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;

        while(fast != null && fast.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;            
        }
        prevSlow.next = null;
        return slow;
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

        ListNode head = mergeSort(h1);
        printList(head);
    }
}