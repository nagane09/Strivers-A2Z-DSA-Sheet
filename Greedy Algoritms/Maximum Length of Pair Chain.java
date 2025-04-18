import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Step 1: Sort pairs based on the second element (end of the pair)
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Initialize variables
        int count = 1;  // At least one pair can be included
        int currentEnd = pairs[0][1];  // End of the first pair

        // Step 3: Traverse through the pairs
        for (int i = 1; i < pairs.length; i++) {
            // Check if the start of the current pair is greater than the currentEnd
            if (pairs[i][0] > currentEnd) {
                // We can add this pair to the chain
                count++;
                currentEnd = pairs[i][1];  // Update currentEnd to the second element of the current pair
            }
        }

        // Step 4: Return the total count of the longest chain
        return count;
    }
}
