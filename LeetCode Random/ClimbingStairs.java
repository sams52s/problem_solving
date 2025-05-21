public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5; // Example input
        System.out.println(climbStairs(n)); // Output: 8
    }

    /**
     * Approach: Dynamic Programming
     * 
     * Algorithm:
     * 1. Base cases: climb(0) = 1, climb(1) = 1
     * 2. Use an array to store the number of ways to reach each step
     * 3. Fill the array using the relation: climb(n) = climb(n-1) + climb(n-2)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int climbStairs(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
