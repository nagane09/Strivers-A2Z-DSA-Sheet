/*Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.

Example 1:

Input:
n = 6
1<->1<->1<->2<->3<->4
Output:
1<->2<->3<->4*/

class Solution{
    Node removeDuplicates(Node head){
        // Code Here.
        if(head==null || head.next==null){
            return head;
        }
        HashSet<Integer> map=new HashSet<>();
        Node temp=head;
        
        while(temp!=null){
            if(map.contains(temp.data)){
                temp.prev.next=temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
            }
            else{
                map.add(temp.data);
            }
            temp=temp.next;
        }
        return head;
    }
}
