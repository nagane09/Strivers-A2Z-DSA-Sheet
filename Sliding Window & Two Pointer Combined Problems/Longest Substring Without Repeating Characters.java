/*Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0,maxLen=0;
        HashSet<Character> alphabet=new HashSet<>();

        while(right<s.length()){
            char ch=s.charAt(right);
            if(!alphabet.contains(ch)){
                alphabet.add(ch);
                maxLen=Math.max(maxLen,right-left+1);
                right++;
            }
            else{
                alphabet.remove(s.charAt(left));
                left++;
            }

        }
        return maxLen;
    }
}
