import java.util.*;
  
  public class Main {
  
      public static Node sublinkedList(Node l1, Node l2) {
          
          if (l1 == null && l2 == null)
              return null;
  
          
          int len1 = getLength(l1);
          int len2 = getLength(l2);
  
          Node lNode = null, sNode = null;
  
          Node temp1 = l1;
          Node temp2 = l2;
  
          
          if (len1 != len2) {
              lNode = len1 > len2 ? l1 : l2;
              sNode = len1 > len2 ? l2 : l1;
              sNode = paddZeros(sNode, Math.abs(len1 - len2));
          }
  
          else {
              
              while (l1 != null && l2 != null) {
                  if (l1.data != l2.data) {
                      lNode = l1.data > l2.data ? temp1 : temp2;
                      sNode = l1.data > l2.data ? temp2 : temp1;
                      break;
                  }
                  l1 = l1.next;
                  l2 = l2.next;
              }
          }
  
          
          borrow = false;
          return subtractLinkedListHelper(lNode, sNode);
      }
  
      public static int getLength(Node node) {
          int size = 0;
          while (node != null) {
              node = node.next;
              size++;
          }
          return size;
      }
  
      
      public static Node paddZeros(Node sNode, int diff) {
          if (sNode == null)
              return null;
  
          Node zHead = new Node(0);
          diff--;
          Node temp = zHead;
          while ((diff--) != 0) {
              temp.next = new Node(0);
              temp = temp.next;
          }
          temp.next = sNode;
          return zHead;
      }
  
      static boolean borrow = false;
  
      
      public static Node subtractLinkedListHelper(Node l1, Node l2) {
          if (l1 == null && l2 == null && borrow == false)
              return null;
  
          Node previous = subtractLinkedListHelper((l1 != null) ? l1.next : null, (l2 != null) ? l2.next : null);
  
          int d1 = l1.data;
          int d2 = l2.data;
          int sub = 0;
  
          
          if (borrow) {
              d1--;
              borrow = false;
          }
  
          
          if (d1 < d2) {
              borrow = true;
              d1 = d1 + 10;
          }
  
          
          sub = d1 - d2;
  
          
          Node current = new Node(sub);
  
          
          current.next = previous;
  
          return current;
      }
  
     
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int a1 = sc.nextInt();
          head = insert(head, a1);
  
          for (int i = 1; i < n; i++) {
              int a = sc.nextInt();
              head = insert(head, a);
          }
  
          int n2 = sc.nextInt();
          int a2 = sc.nextInt();
          head2 = insert(head2, a2);
  
          for (int i = 1; i < n2; i++) {
              int a = sc.nextInt();
              head2 = insert(head2, a);
          }
  
          head3 = sublinkedList(head, head2);
          display(head3);
  
      }
  
    
      static class Node {
          int data;
          Node next;
  
          public Node(int data) {
              this.data = data;
              this.next = null;
          }
  
      }
  
      static Node head;
  
      static Node head2;
  
      static Node head3;
  
      public static Node insert(Node head, int data) {
  
          if (head == null) {
              return new Node(data);
          }
  
          head.next = insert(head.next, data);
          return head;
      }
  
      public static void display(Node head) {
          for (Node node = head; node != null; node = node.next) {
              System.out.print(node.data + " ");
          }
      }
  
  }
                        
                        