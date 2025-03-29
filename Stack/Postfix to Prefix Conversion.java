/*Input: 
ABC/-AK/L-*
Output: 
*-A/BC-/AKL
Explanation: 
The above output is its valid prefix form.
*/

class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> s=new Stack<>();
        String result="";
        
        for(int i=0;i<post_exp.length();i++){
            char ch=post_exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                s.push(ch+"");
            }
            else{
                if(s.size()<2){
                    return "Invalid Expression";
                }
                String ch1=s.pop();
                String ch2=s.pop();
                String ans=ch+ch2+ch1;
                s.push(ans);
            }
        }
        if(s.size()!=1){
            return "Invalid Expression";
        }
        return s.peek();
        
    }
}
