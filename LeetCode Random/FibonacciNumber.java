import java.util.HashMap;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 10; // Example input
        System.out.println(fib(n)); // Output: 55
    }

    /**
     * Approach: Dynamic Programming
     * 
     * Algorithm:
     * 1. Base cases: fib(0) = 0, fib(1) = 1
     * 2. Use an array to store Fibonacci numbers up to n
     * 3. Fill the array using the relation: fib(n) = fib(n-1) + fib(n-2)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            System.out.println("i = " + i); // Debugging line to check the current index
            System.out.println("dp[i - 1] = " + dp[i - 1]); // Debugging line to check the previous Fibonacci number
            System.out.println("dp[i - 2] = " + dp[i - 2]); // Debugging line to check the Fibonacci number before the previous one
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println("dp[i] = " + dp[i]); // Debugging line to check the current Fibonacci number
        }
        return dp[n];
    }
    public static int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    public static int fib3(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        return fibHelper(n, memo);
    }

    private static int fibHelper(int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        int result = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        memo.put(n, result);
        return result;
    }
}
