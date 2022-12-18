// Leetcode q_no: 138

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void copyList(Node head){
        Node curr = head;
        while(curr != null){
            Node forw = curr.next;
            
            Node node = new Node(curr.val);
            curr.next = node;
            node.next = forw;
            
            curr = forw; 
        }
    }
    
    public Node copyRandomList(Node head) {
        copyList(head);
        Node curr = head;
        
        while(curr != null){
            Node random = curr.random;
            if(random != null){
                curr.next.random = random.next;
            }
            curr = curr.next.next;
        }
        Node dummy = new Node(0);
        Node prev = dummy;
        
        curr = head;
        while(curr != null){
            prev.next = curr.next;
            prev = prev.next;
            curr.next = prev.next;
            curr = curr.next;
            //prev = curr.next;
        }
        
        return dummy.next;
    }
}