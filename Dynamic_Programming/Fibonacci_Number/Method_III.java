package Dynamic_Programming.Fibonacci_Number;

// Space Optimized Method
public class Method_III {

    // Time Complexity -> O(N) -> We are using only a simple for loop
    // Space Complexity -> O(1) -> Constant Space (We are not using any extra space)
    public static void main(String[] args) {
        int n = 6;
        int prev2 = 0;
        int prev = 1;

        for(int i = 2; i <= n; i++){
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }

        System.out.println("Fibonacci number at index " + n + " is: " + prev);
    }
}
