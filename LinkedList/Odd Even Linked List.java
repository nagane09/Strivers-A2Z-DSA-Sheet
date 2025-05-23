/*Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even 
indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode a=head;
        ListNode b=head.next;
        ListNode headNew=b;

        while(b!=null && b.next!=null){
            a.next=b.next;
            a=a.next;
            b.next=a.next;
            b=b.next;
            
        }
        a.next=headNew;
        return head;
        
    }
}
