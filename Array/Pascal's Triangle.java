/*Given an integer numRows, return the first numRows of Pascal's triangle.

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
Input: numRows = 1
Output: [[1]]*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> rows=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    rows.add(1);
                }
                else{
                    rows.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(rows);
        }
        return triangle;
    }
}
