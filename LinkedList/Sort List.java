/*Given the head of a linked list, return the list after sorting it in ascending order.
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Input: head = []
Output: []*/

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid=getMid(head);
        ListNode secHalf=mid.next;
        mid.next=null;

        ListNode left=sortList(head);
        ListNode right=sortList(secHalf);

        return merge(left,right);
    }

    public ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                temp.next=l1;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null){
            temp.next=l1;
        }
        if(l2!=null){
            temp.next=l2;
        }
        return dummy.next;
    }
}
