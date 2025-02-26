/*Given an array arr containing both positive and negative integers, the task is to compute the length of the largest subarray that has a sum of 0.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.*/

class Solution {
    int maxLen(int arr[]) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixSum=0,maxLen=0;
        
        for(int i=0;i<arr.length;i++){
            prefixSum += arr[i];
            
            if(prefixSum==0){
                maxLen=i+1;
            }
            if(map.containsKey(prefixSum)){
                maxLen=Math.max(maxLen,i-map.get(prefixSum));
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
        }
        return maxLen;
    }
}
