// import java.util.Arrays;

public class SubsetSumEqualsK {

    // Memoization Approach
    public static int isSubsetSum(int[] arr, int idx, int target, int[][] dp) {
        if(target == 0) return 1;
        if(idx == 0) {
            if(target == arr[idx]) return 1;
            else return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = isSubsetSum(arr, idx - 1, target, dp);
        int take = 0;
        if(target >= arr[idx]) {
            take = isSubsetSum(arr, idx - 1, target - arr[idx], dp);
        }

        if(notTake == 1 || take == 1) return dp[idx][target] = 1;
        else return dp[idx][target] = 0;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int target = 4;

        int n = arr.length;

        // int[][] dp = new int[n][target + 1];
        // for(int[] row: dp) Arrays.fill(row, -1);

        // System.out.println(isSubsetSum(arr, n - 1, target, dp));

        // Tabulation Approach
        boolean[][] dp = new boolean[n][target + 1];

        // Base Cases
        for(int i = 0; i < n; i++) dp[i][0] = true;
        dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++) {
            for(int tar = 1; tar <= target; tar++) {
                boolean notTake = dp[i - 1][tar];
                boolean take = false;
                if(tar >= arr[i]) take = dp[i - 1][tar - arr[i]];

                dp[i][tar] = notTake || take;
            }
        }

        System.out.println(dp[n - 1][target]);
    }
}
