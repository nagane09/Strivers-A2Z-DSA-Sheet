/*Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked 
list such that all zeros segregate to the head side, 2s at the end of the linked list, and 1s in the middle of 0s and 2s.

Examples:

Input: LinkedList: 1->2->2->1->2->0->2->2
Output: 0->1->1->2->2->2->2->2*/

class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }


        int count1=0;
        int count2=0;
        int count3=0;
        Node temp=head;
        
        while(temp!=null){
            if(temp.data==0){
                count1++;
            }
            else if(temp.data==1){
                count2++;
            }
            else{
                count3++;
            }
            temp=temp.next;
        }
        
        temp=head;
        
        while(count1>0){
            temp.data=0;
            temp=temp.next;
            count1--;
        }
        while(count2>0){
            temp.data=1;
            temp=temp.next;
            count2--;
        }
        while(count3>0){
            temp.data=2;
            temp=temp.next;
            count3--;
        }
        return head;
        
    }
}
