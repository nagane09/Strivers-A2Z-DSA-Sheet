/*There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.*/

class Solution {
    public int candy(int[] ratings) {
        // Array to store the count of candies for each child
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1); // Initially assign each child 1 candy

        // Traverse from left to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1; // Give 1 more candy if current rating is higher than previous
            }
        }

        // Traverse from right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1); // Ensure the count is maximized from both directions
            }
        }

        // Calculate total candies
        int ans = 0;
        for (int i : count) {
            ans += i;
        }
        return ans;
    }
}
