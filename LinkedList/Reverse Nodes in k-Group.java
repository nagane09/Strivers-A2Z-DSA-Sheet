/*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a 
multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // Step 2: Reverse k nodes if possible
        if (count == k) {
            ListNode prev = null, curr = head, next = null;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: Connect with the next reversed part
            head.next = reverseKGroup(curr, k);

            // Step 4: Return new head (prev is the new head after reversing)
            return prev;
        }

        // If less than k nodes are left, return head as is
        return head;
    
    }
}

