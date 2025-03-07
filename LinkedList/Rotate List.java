/*Given the head of a linked list, rotate the list to the right by k places.

Input: head = [0,1,2], k = 4
Output: [2,0,1]*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode temp=head;
        int length=1;
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }

        k=k%length;
        if(k==0){
            return head;
        }
        temp.next=head;
        int neww=length-k;
        ListNode newTail =head;
        for (int i = 1; i < neww; i++) {
            newTail = newTail.next;
        }
        head=newTail.next;
        newTail.next=null;
        return head;
    }
}
