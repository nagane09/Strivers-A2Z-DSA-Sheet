/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int candidate1=0,candidate2=0,count1=0,count2=0;
        int n=nums.length;

        for(int i:nums){
            if(i==candidate1){
                count1++;
            }
            else if(i==candidate2){
                count2++;
            }
            else if(count1==0){
                candidate1=i;
                count1++;
            }
            else if(count2==0){
                candidate2=i;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int i:nums){
            if(i==candidate1){
                count1++;
            }
            else if(i==candidate2){
                count2++;
            }
        }

        List<Integer> result=new ArrayList<>();
        if(count1>(n/3)){
            result.add(candidate1);
        }
        if(count2>(n/3)){
            result.add(candidate2);
        }
        return result;

    }
}

/*We iterate through nums and maintain two candidates along with their counts.

Step	Number	Candidate1	Count1	Candidate2	Count2	Explanation
1	1	1	1	-	0	First candidate is 1
2	1	1	2	-	0	1 appears again, so count increases
3	2	1	2	2	1	New candidate 2
4	3	1	2	2	1	3 appears, both counts decrease
5	1	1	1	2	0	1 appears again, count1 increases
6	2	1	1	2	1	2 appears again, new candidate 2
7	2	1	1	2	2	2 appears again, count2 increases
8	3	1	0	2	2	3 appears, count1 decreases
9	2	1	0	2	3	2 appears, count2 increases
At the end of this phase:
✅ Candidate1 = 1
✅ Candidate2 = 2*/
