/*Input: s = "a+b*(c^d-e)^(f+g*h)-i"
Output: abcd^e-fgh*+^*+i-
Explanation: After converting the infix expression into postfix expression, the resultant expression will be 
abcd^e-fgh*+^*+i-*/

class Solution {
    // Function to convert an infix expression to a postfix expression.
    
    static int precedence(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
                    
            case '*':
            case '/':
                return 2;
                
            case '^':
                return 3;
                
        }
        return -1;
            
    }
    
    public static String infixToPostfix(String s) {
        // Your code here
        String result="";
        Stack<Character> s1=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(c=='('){
                s1.push(c);
            }
            else if(Character.isLetterOrDigit(c)){
                result+=c;
            }
            else if(c==')'){
                while(!s1.isEmpty() && s1.peek()!='('){
                    result+=s1.pop();
                }
                if(s1.isEmpty()){
                    return "Invalid Expression";
                }
                else{
                    s1.pop();
                }
            }
            else{
                while(!s1.isEmpty() && precedence(c)<=precedence(s1.peek())){
                    if(s1.peek() == '('){
                        return "Invalid Expression";
                    }
                    result+=s1.pop();
                }
                s1.push(c);
            }
        }
        while(!s1.isEmpty()){
            if(s1.peek() == '('){
                return "Invalid Expression";
            }
            result+=s1.pop();
        }
        return result;
    }
}
