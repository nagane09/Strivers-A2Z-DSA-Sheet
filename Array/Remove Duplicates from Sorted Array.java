/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be 
kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important 
as well as the size of nums.
Return k.

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; 

        int j = 0; // Slow pointer

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) { 
                j++;
                nums[j] = nums[i]; 
            }
        }
        
        return j + 1;
    }
}
