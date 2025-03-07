/*Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Node left=head;
        Node right=head;
        
        while(right.next!=null){
            right=right.next;
        }
        
        while(left!=null && right!=null && left!=right && right.next!=left){
            int sum=left.data+right.data;
            
            if(sum==target){
                result.add(new ArrayList<>(Arrays.asList(left.data,right.data)));
                left=left.next;
                right=right.prev;
            }
            else if(sum<target){
                left=left.next;
            }
            else{
                right=right.prev;
            }
        }
        return result;
    }
}
