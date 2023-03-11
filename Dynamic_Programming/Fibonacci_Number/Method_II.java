package Dynamic_Programming.Fibonacci_Number;

// Tabulation Method
public class Method_II {

    // Time Complexity -> O(N) -> We are using only a simple for loop
    // Space Complexity -> O(N) -> We are using an extra array of size N + 1
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println("Fibonacci number at index " + n + " is: " + dp[n]);
    }
}
