import java.util.Arrays;

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

        int[][] dp = new int[n][target + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        System.out.println(isSubsetSum(arr, n - 1, target, dp));
    }
}
