/*Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 */

class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else { // ch == '*'
                low--;    // treat '*' as ')'
                high++;   // treat '*' as '('
            }

            if (high < 0) return false; // Too many ')'
            if (low < 0) low = 0;       // can't go below 0
        }

        return low == 0;
    }
}
