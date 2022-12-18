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

  public static ListNode segregate(ListNode head, int pivotIdx) {
      if(head == null || head.next == null) return head;

      ListNode pivot = head;
      for(int i = 0; i<pivotIdx; i++){
        pivot = pivot.next;
      }

      int data = pivot.val;

      ListNode small = new ListNode(-1);
      ListNode large = new ListNode(-1), ps = small, pl = large;

      ListNode curr = head;
      int idx = 0;

      while(curr != null){
        if(idx != pivotIdx){
          if(curr.val <= data){
            ps.next = curr;
            ps = ps.next;
          }
          else{
            pl.next = curr;
            pl = pl.next;
          }
        }
        curr = curr.next;
        idx++;
      }
      pl.next = null;
      pivot.next = large.next;
      ps.next = pivot;
      return small.next;
  }

  // public static void addLast(ListNode head, int val){
  //   if(head == null ){
  //     head = new ListNode(val);
  //     return;
  //   }
  //   ListNode curr = head;

  //   while(curr.next != null){
  //     curr = curr.next;
  //   }

  //   curr.next = new ListNode(val);
  // }

  // public static void remove(ListNode head, int val){
  //   if(head == null){
  //     return;
  //   }

  //   ListNode curr = head;
  //   if(head.val == val ){
  //     return head.next;
  //   }
  //   prev = head;
  //   curr = head.next;
  //   while(curr != null){
  //     if(curr.val == val){
  //       prev.next = curr.next;
  //     }
  //     curr
  //   }
  // }

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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}