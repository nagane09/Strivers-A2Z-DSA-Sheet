/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][];
        }
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        List<int[]> merged=new ArrayList<>();

        for(int[] i:intervals){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < i[0]){
                merged.add(i);
            }
            else{
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1] , i[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
