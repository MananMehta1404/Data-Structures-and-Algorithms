package Dynamic_Programming.Fibonacci_Number;

// Memoization Method
public class Method_I {
    // Time Complexity -> O(N) -> The overlapping subproblems will return the answer in constant time O(1). Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).
    // Space Complexity -> O(N) -> We are using a recursion stack space(O(N)) and an array (again O(N)). Therefore total space complexity will be O(N) + O(N) ≈ O(N) 
    public static int fib(int n, int[] dp){
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        for(int i = 0; i < dp.length; i++) dp[i] = -1;

        System.out.println("Fibonacci number at index " + n + " is: " + fib(n, dp));
    }
}
