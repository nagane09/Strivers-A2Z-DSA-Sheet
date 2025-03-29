/*Input: 
*-A/BC-/AKL
Output: 
ABC/-AK/L-*
Explanation: 
The above output is its valid postfix form.*/

class Solution {
    static String preToPost(String pre_exp) {
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
                
                String ans=ch1+ch2+ch;
                s.push(ans);
            }
        }
        if(s.size()!=1){
            return "Invalid Expression";
        }
        return s.peek();
    }
}
