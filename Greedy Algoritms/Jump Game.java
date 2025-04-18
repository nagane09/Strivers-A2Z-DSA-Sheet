/*You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length 
at that position.
Return true if you can reach the last index, or false otherwise.
Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.*/

class Solution {
    public boolean canJump(int[] nums) {
        int MaxReach=0;

       for(int i=0;i<nums.length;i++)
       {
            if(i>MaxReach)
            {
                return false;
            }
            MaxReach=Math.max(MaxReach,i+nums[i]);

            if(MaxReach>=nums.length-1){
                return true;
            }
       }
       return false;    //this is only reached when we can't reach last index
    }
}

/*Dry Run (nums = [2, 3, 1, 1, 4]):

Start: maxReach = 0
At index 0: nums[0] = 2, maxReach = max(0, 0 + 2) = 2
At index 1: nums[1] = 3, maxReach = max(2, 1 + 3) = 4
Conclusion: maxReach = 4 (>= last index), so return true.
Result: true*/
