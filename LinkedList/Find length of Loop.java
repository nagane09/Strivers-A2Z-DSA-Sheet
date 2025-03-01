/*Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number 
of nodes in the loop, otherwise return 0.

Input: LinkedList: 25->14->19->33->10->21->39->90->58->45, c = 4
Output: 7
Explanation: The loop is from 33 to 45. So length of loop is 33->10->21->39-> 90->58->45 = 7. 
The number 33 is connected to the last node of the linkedlist to form the loop because according to the input the 4th 
node from the beginning(1 based indexing) 
will be connected to the last node for the loop.*/

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                return countLoopLength(slow);
            }
        }
        return 0;
    }
    public int countLoopLength(Node loopNode) {
        int count = 1;
        Node temp = loopNode.next;

        while (temp != loopNode) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
