/*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To 
accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while(i>=0 && j>=0)
        {
            if(nums1[i]>nums2[j])
            {
                nums1[k]=nums1[i];
                i--;
            }
            else
            {
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        while(j>=0)
        {
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }

}

/*nums1 = {0, 0, 3, 0, 0, 0}, m = 3
nums2 = {1, 2, 4}, n = 3
Steps:
Compare 3 (nums1[2]) and 4 (nums2[2]): Place 4 at nums1[5].
Compare 3 (nums1[2]) and 2 (nums2[1]): Place 3 at nums1[4].
Compare 0 (nums1[1]) and 2 (nums2[0]): Place 2 at nums1[3].
Place remaining 1 at nums1[2].
Final nums1:
java
Copy code
nums1 = {1, 2, 3, 4, 0, 0}*/
