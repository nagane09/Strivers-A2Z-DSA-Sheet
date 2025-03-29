/*Input: [[1,2], [1,3], [2], [1,4], [2]]
Output: [3, 4]
Explanation: 
push(2)  : the stack will be {2}
push(3)  : the stack will be {2 3}
pop()    : poped element will be 3,the stack will be {2}
push(4)  : the stack will be {2 4}
pop()    : poped element will be 4*/

class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        StackNode newNode = new StackNode (a);
        if(top==null){
            top=newNode;
        }
        else{
            newNode.next=top;
            top=newNode;
        }
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if (top == null) {
            return -1;  // Stack is empty
        }

        int poppedData = top.data; // Get data to return
        top = top.next;            // Move top to next node
        
        return poppedData;
    }
}
