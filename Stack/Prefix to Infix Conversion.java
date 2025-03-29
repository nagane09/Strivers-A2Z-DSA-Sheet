/*Input: 
*-A/BC-/AKL
Output: 
((A-(B/C))*((A/K)-L))
Explanation: 
The above output is its valid infix form.*/

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> s=new Stack<>();
        String result="";
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                s.push(ch+"");
            }
            else{
                if(s.size()<2){
                    return "Invalid Expression";
                }
                String ch1=s.pop();
                String ch2=s.pop();
                String exp="("+ch1+ch+ch2+")";
                s.push(exp);
            }
        }
        if(s.size()!=1){
            return "Invalid Expression";
        }
        return s.peek();
    }
}
