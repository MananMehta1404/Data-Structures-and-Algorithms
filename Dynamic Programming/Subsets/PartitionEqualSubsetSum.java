import java.util.Arrays;

public class PartitionEqualSubsetSum {

    // Memoization Approach
    public static int isPossible_Memo(int[] arr, int idx, int target, int[][] dp) {
        if(target == 0) return 1;
        if(idx == 0) {
            if(target == arr[idx]) return 1;
            else return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = isPossible_Memo(arr, idx - 1, target, dp);
        int take = 0;
        if(target >= arr[idx]) {
            take = isPossible_Memo(arr, idx - 1, target - arr[idx], dp);
        }

        if(notTake == 1 || take == 1) return dp[idx][target] = 1;
        else return dp[idx][target] = 0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};

        int n = arr.length;
        int totalSum = 0;
        for(int i = 0; i < n; i++) totalSum += arr[i];

        int target = totalSum / 2;

        // Memoization Approach
        int[][] dp1 = new int[n][target + 1];
        for(int[] row: dp1) Arrays.fill(row, -1);

        int ans1 = 0;
        if(totalSum % 2 == 0) {
            ans1 = isPossible_Memo(arr, n - 1, target, dp1);
        }
        
        System.out.println(ans1);
    }
}
