/*Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.*/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            minDiff=Math.min(minDiff,arr[i]-arr[i-1]);
        }

        List<List<Integer>> result=new ArrayList<>();

        for(int i=1;i<arr.length;i++){
            if((arr[i]-arr[i-1])==minDiff){
                result.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return result;
    }
}
