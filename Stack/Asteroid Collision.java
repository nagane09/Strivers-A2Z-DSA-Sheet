/*We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array 
represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative 
meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, 
both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s1=new Stack<>();

        for(int curr:asteroids){
            boolean destroyed=false;
            while(!s1.isEmpty() && curr<0 && s1.peek()>0){
                
                if(s1.peek()<-curr){
                    s1.pop();
                    continue;
                }
                if(s1.peek()==-curr){
                    s1.pop();
                }
                destroyed=true;
                break;
            }
            if(!destroyed){
                s1.push(curr);
            }
        }
        int[] temp=new int[s1.size()];
        for (int i = s1.size() - 1; i >= 0; i--) {
            temp[i] = s1.pop();
        }
        return temp;
    }
}
