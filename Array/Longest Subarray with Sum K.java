/*Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray 
where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:
Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest 
subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.*/

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixSum=0,maxLen=0;
        
        for(int i=0;i<arr.length;i++){
            prefixSum += arr[i];
            
            if(prefixSum==k){
                maxLen=i+1;
            }
            if(map.containsKey(prefixSum-k)){
                maxLen=Math.max(maxLen,i-map.get(prefixSum-k));
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
        }
        return maxLen;
    }
}
