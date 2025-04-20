/*Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroCount = 0, maxLen = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // valid window, update maxLen
            maxLen = Math.max(maxLen, right - left + 1);
            right++; // always move right
        }

        return maxLen;
    }
}
