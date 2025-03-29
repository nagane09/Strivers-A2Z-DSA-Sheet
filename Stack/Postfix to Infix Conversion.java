/*Input:
ab*c+ 
Output: 
((a*b)+c)
Explanation: 
The above output is its valid infix form.*/

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> s=new Stack<>();
        String result="";
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                s.push(ch+"");
            }
            else{
                if(s.size()<2){
                    return "Invalid Expression";
                }
                String ch1=s.pop();
                String ch2=s.pop();
                String ans="("+ch2+ch+ch1+")";
                s.push(ans);
            }
        }
        if(s.size()!=1){
            return "Invalid Expression";
        }
        return s.peek();
    }
}
