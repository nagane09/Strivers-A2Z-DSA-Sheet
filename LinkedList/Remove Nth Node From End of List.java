/*Given the head of a linked list, remove the nth node from the end of the list and return its head.

 Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null; 
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int itr=count-n;
        if (itr == 0){
            return head.next;
        }
        temp=head;
        for(int i=1;i<itr;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;

        return head;
    }
}
