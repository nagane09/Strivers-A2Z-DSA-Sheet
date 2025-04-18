/*You are given:

A list of children's greed factors (int[] g)

A list of cookie sizes (int[] s)

Each child can get at most one cookie, and a child is satisfied if the cookie size is ≥ the child's greed factor.

Your task is to maximize the number of satisfied children.

✅ What you have to do:
You need to assign cookies to children in such a way that:

Every child gets at most one cookie.

A cookie can only satisfy one child.

The goal is to satisfy as many children as possible.

📘 Example:
java
Copy
Edit
g = [1, 2, 3]    // children's greed
s = [1, 1]       // cookie sizes

Output: 1
Explanation: 
- Only one child (with greed 1) can be satisfied with a cookie of size 1.
- So, answer is 1.
🎯 Approach (Greedy):
Sort both arrays g and s.

Use two pointers:

One for the children (i)

One for the cookies (j)

For each cookie, try to satisfy the current child.

If the cookie size is ≥ greed, assign the cookie and move both pointers.

Else, move the cookie pointer to try a bigger cookie.

✅ Java Code:
java
Copy
Edit
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed
        Arrays.sort(s); // Sort cookie sizes

        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // child is satisfied
            }
            j++; // move to next cookie
        }

        return i; // number of satisfied children
    }
}
🧠 Example Walkthrough:
java
Copy
Edit
g = [1,2,3]
s = [1,1]

Sort both:
g = [1,2,3]
s = [1,1]

Try:
- Cookie 1 (size 1) → child 1 (greed 1) → ✅
- Cookie 2 (size 1) → child 2 (greed 2) → ❌

Only 1 child is satisfied → output is 1
Let me know if you want a dry run with your own inputs or want to implement this step-by-step!*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0, j=0;
        while(i<g.length && j<s.length ){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}
