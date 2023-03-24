package Dynamic_Programming;

public class HouseRobber_I {
    // Memoization Method
    public static int rob(int[] nums, int idx, int[] dp) {
        if(idx == 0) return nums[0];
        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int rob = rob(nums, idx - 2, dp) + nums[idx];
        int notRob = rob(nums, idx - 1, dp);

        return dp[idx] = Math.max(rob, notRob);
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 6, 9};
        int n = nums.length;

        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = -1;

        System.out.println("Maximum amount of money that can be robbed is: " + rob(nums, n - 1, dp));
    }
}
