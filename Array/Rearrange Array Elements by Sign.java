/*Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex=0,negIndex=1;
        for(int i:nums){
            if(i>0){
                result[posIndex]=i;
                posIndex+=2;
            }
            else{
                result[negIndex]=i;
                negIndex+=2;
            }
        }
        return result;
    }
}
