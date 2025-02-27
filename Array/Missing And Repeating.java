/*Given an unsorted array arr of positive integers. One number a from the set [1, 2,....,n] is missing and one number
b occurs twice in the array. Find numbers a and b.
Note: The test cases are generated such that there always exists one missing and one repeating number within the range
[1,n].

Examples:

Input: arr[] = [2, 2]
Output: [2, 1]
Explanation: Repeating number is 2 and smallest positive missing number is 1.
Input: arr[] = [1, 3, 3] 
Output: [3, 2]
Explanation: Repeating number is 3 and smallest positive missing number is 2.*/

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        int r1=-1;
        int r2=-1;
        
        for(int i=0;i<arr.length;i++){
            int idx=Math.abs(arr[i])-1;
            if(arr[idx]<0){
                r1=Math.abs(arr[i]);
            }
            else{
                arr[idx]=-arr[idx];
            }
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                r2=i+1;
            }
        }
        result.add(r1);
        result.add(r2);
        return result;
    }
}
