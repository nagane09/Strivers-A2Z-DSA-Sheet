/*Given a binary array nums, return the maximum number of consecutive 1's in the array.
Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum=0;
        int maxNum=0;

        for(int i:nums){
            if(i==1){
                sum++;
            }
            else{
                maxNum=Math.max(maxNum,sum);
                sum=0;
            }

        }
        maxNum=Math.max(maxNum,sum);
        return maxNum;
    }
}
