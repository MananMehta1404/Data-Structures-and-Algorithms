package Dynamic_Programming.HouseRobber_I;

public class Method_II {
    // Tabulation Method
    public static void main(String[] args) {
        int[] nums = {2, 1, 6, 9};
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            int rob = nums[i];
            if(i > 1) rob += dp[i - 2];
            int notRob = dp[i - 1];

            dp[i] = Math.max(rob, notRob);
        }

        System.out.println("Maximum amount of money that can be robbed is: " + dp[n - 1]);
    }
}
