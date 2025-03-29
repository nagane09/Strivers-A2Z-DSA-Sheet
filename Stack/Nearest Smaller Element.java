/*Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
For Example

Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]
Explaination 1:
    index 1: No element less than 4 in left of 4, G[1] = -1
    index 2: A[1] is only element less than A[2], G[2] = A[1]
    index 3: No element less than 2 in left of 2, G[3] = -1
    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]*/

public class Solution {
    public int[] prevSmaller(int[] A) {
        int n=A.length;
        Stack<Integer> s1=new Stack<>();
        int[] result=new int[n];
        result[0]=-1;
        s1.push(A[0]);
        
        for(int i=1 ; i<n ;i++){
            int curr=A[i];
            while(!s1.isEmpty() && curr<=s1.peek()){
                s1.pop();
            }
            if(s1.isEmpty()){
                result[i]=-1;
            }
            else{
                result[i]=s1.peek();
            }
            s1.push(A[i]);
        }
        return result;
    }
}
