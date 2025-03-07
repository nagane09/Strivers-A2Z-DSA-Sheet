/*Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom pointer to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation: 
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.*/

class Solution {
    // Function to flatten a linked list
    Node merge(Node a,Node b){
        if(a==null){ 
            return b;
        }
        if(b==null){ 
            return a;
        }
        
        Node result;
        
        if(a.data<b.data){
            result=a;
            result.bottom=merge(a.bottom,b);
        }else{
            result=b;
            result.bottom=merge(a,b.bottom);
        }
        result.next=null;
        return result;
    }
    
    Node flatten(Node root) {
        
        if(root==null || root.next==null){
            return root;
        }
        
        root.next=flatten(root.next);
        root= merge(root,root.next);
        return root;
    }
}
