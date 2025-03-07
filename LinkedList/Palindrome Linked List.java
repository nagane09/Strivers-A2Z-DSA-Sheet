/*Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true
Example 2:

Input: head = [1,2]
Output: false*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; // A single node or empty list is always palindrome

        // Step 1: Find the middle using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        slow = rev(slow);  // Corrected: Reverse from slow instead of slow.next

        ListNode first = head;
        ListNode sec = slow;

        // Step 3: Compare both halves
        while (sec != null) {
            if (first.val != sec.val) {
                return false;
            }
            first = first.next;
            sec = sec.next;
        }
        return true;
    }

    // Helper function to reverse a linked list
    public ListNode rev(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev; // New head of reversed list
    }
}
