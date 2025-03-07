/*You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key 
if it is present and return the new DLL.

Example1:

Input: 
2<->2<->10<->8<->4<->2<->5<->2
2*/

class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        while(head!=null && head.data==x){
            head=head.next;
            if(head != null){
                head.prev=null;
            }
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                temp.prev.next=temp.next;
                if (temp.next != null) {
                    temp.next.prev=temp.prev;
                }
                
            }
            temp=temp.next;
        }
        return head;
    }
}
