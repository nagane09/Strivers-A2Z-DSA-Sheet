/*You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the
number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Input: LinkedList: 4->5->6
Output: 457*/

class Solution {
    
    public Node rev(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node nexxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nexxt;
        }
        return prev;
    }
    
    public Node addOne(Node head) {
        // code here.
        head=rev(head);
        Node temp=head;
        int carry=1;
        
        while(temp!=null && carry>0){
            if (head == null) {
                return new Node(1);
            }
            
            int sum = temp.data+carry;
            temp.data = sum%10;
            carry = sum/10;
            
            if(temp.next==null && carry>0){
                temp.next=new Node(0);
            }
            temp=temp.next;
        }
        return rev(head);
    }
    
    
}
