/*You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is 
considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

Examples:
Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.*/

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int i=n-2;
        int maxElement=arr[n-1];
        
        ans.add(maxElement);
        while(i>=0){
            if(arr[i]>=maxElement){
                maxElement=arr[i];
                ans.add(maxElement);
            }
            i--;
        }
        Collections.reverse(ans);
        return ans;
    }
}
