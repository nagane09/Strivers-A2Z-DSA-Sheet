/*Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.*/

class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> s=new Stack<>();

        for(char ch:num.toCharArray()){
            while(!s.isEmpty() && k>0 && s.peek()>ch){
                s.pop();
                k--;
            }
            s.push(ch);
        }

        while(k>0 && !s.isEmpty()){
            s.pop();
            k--;
        }

        StringBuilder str=new StringBuilder();
        for(char ch:s){
            str.append(ch);
        }

        while(str.length()>0 && str.charAt(0)=='0'){
            str.deleteCharAt(0);
        }

        return str.length()==0?"0":str.toString();
    }

}
