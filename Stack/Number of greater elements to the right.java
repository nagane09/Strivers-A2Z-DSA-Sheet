/*Input: arr[] = [3, 4, 2, 7, 5, 8, 10, 6], queries = 2, indices[] = [0, 5]
Output:  [6, 1]
Explanation: The next greater elements to the right of 3(index 0) are 4,7,5,8,10,6. The next greater elements to the right of 8(index 5) is only 10.*/

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    Stack<Integer> s1=new Stack<>();
    int[] result=new int[indices.length];
    
    for(int i=0;i<indices.length;i++){
        int count=0;
        int curr=arr[indices[i]];
        for(int j=indices[i];j<arr.length;j++){
            if(arr[j]>curr){
                count++;
            }
        }
        result[i]=count;
    }
    return result;
    
  }
}
