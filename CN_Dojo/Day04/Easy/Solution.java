import java.util.* ;
import java.io.*; 

/************************************************************

 Following is the linkedList class structure:

 class Node<T> {
 T data;
 Node<T> next;

 public Node(T data) {
 this.data = data;
 }
 }

 ************************************************************/

public class Solution {

    static Node insert(Node head, int n, int pos, int val) {
        // Write your code here.
        if(head == null){
            head.data = val;
            head.next.data = -1;
            return head;
        }

        if(pos == 0){
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
            return head;
        }

        int j = 0;
        Node temp = head;
        while(j != pos-1 && temp != null){
            temp = temp.next;
            j++;
        }

        Node addIt = new Node(val);
        Node nextNode = temp.next;
        temp.next = addIt;
        addIt.next = nextNode;

        return head;
    }
}