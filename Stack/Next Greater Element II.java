/*Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next 
greater number. If it doesn't exist, return -1 for this number.

 Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        Stack<Integer> s1=new Stack<>();
        Arrays.fill(result, -1);

        for(int idx=2*n-1;idx>=0;idx--){
            int currIdx=idx%n;
            int newNum=nums[currIdx];

            while(!s1.isEmpty() && newNum>=s1.peek()){
                s1.pop();
            }
            if(!s1.isEmpty()){
                result[currIdx]=s1.peek();
            }
            s1.push(newNum);
        }
        return result;
    }
}
