package javaProblemsSolution;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestinLexicographicalOrder {
        public int findKthNumber(int n, int k) {
            long curr = 1;
            k--;  // Start from the 0th index

            while (k > 0) {
                long count = getCount(curr, n);
                if (count <= k) {
                    // If the current prefix has fewer numbers than k, move to the next prefix
                    curr++;
                    k -= count;
                } else {
                    // If the current prefix has enough numbers, go deeper into this prefix
                    curr *= 10;
                    k--;  // Decrement k for exploring the next number
                }
            }

            return (int) curr;
        }

        // Function to count how many numbers are lexicographically between curr and curr + 1
        private long getCount(long curr, long n) {
            long count = 0;
            long next = curr + 1;

            while (curr <= n) {
                count += Math.min(n + 1, next) - curr;
                curr *= 10;
                next *= 10;
            }

            return count;
        }

}
