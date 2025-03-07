/*Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the
two linked lists have no intersection at all, return null.
For example, the following two linked lists begin to intersect at node c1:
The test cases are generated such that there are no cycles anywhere in the entire linked structure.
Note that the linked lists must retain their original structure after the function returns.

Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the
intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node 
in B) are different node references. In other words, they point to two different locations in memory, while the nodes 
with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1=headA;
        ListNode ptr2=headB;

        while(ptr1!=ptr2){
            if(ptr1==null){
                ptr1=headB;
            }
            else{
                ptr1=ptr1.next;
            }
            if(ptr2==null){
                ptr2=headA;
            }
            else{
                ptr2=ptr2.next;
            }
        }
        return ptr1;
    }
}
