/*Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the 
elements in the union of the two arrays in sorted order.
Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.

Examples:
Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: 1 2 3 4 5 6 7
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.*/

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        Set<Integer> unique=new HashSet<>();
        for(int i:a){
            unique.add(i);
        }
        for(int i:b){
            unique.add(i);
        }
        ArrayList<Integer> ans=new ArrayList<>(unique);
        Collections.sort(ans);
        return ans;
    }
}
