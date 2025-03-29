/*Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
Input: heights = [2,4]
Output: 4
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nsl=new int[n];
        int[] nsr=new int[n];
        Stack<Integer> s1=new Stack<>();

        nsl[0]=-1;
        s1.push(0);

        for(int i=1;i<n;i++){
            int curr=heights[i];
            while(!s1.isEmpty() && curr<=heights[s1.peek()]){
                s1.pop();
            }
            if(s1.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s1.peek();
            }
            s1.push(i);
        }
        
        s1.clear();

        nsr[n-1]=n;
        s1.push(n-1);

        for(int i=n-2;i>=0;i--){
            int curr=heights[i];
            while(!s1.isEmpty() && curr<=heights[s1.peek()]){
                s1.pop();
            }
            if(s1.isEmpty()){
                nsr[i]=n;
            }
            else{
                nsr[i]=s1.peek();
            }
            s1.push(i);
        }

        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int currHeigth=heights[i];
            int width = nsr[i]-nsl[i]-1;
            int area=currHeigth*width;
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}
