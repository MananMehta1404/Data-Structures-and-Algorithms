import java.util.Arrays;

public class LIS {

    // Memoization Approach
    public static int lengthOfLIS(int idx, int prev_idx, int[] arr, int[][] dp) {
        if(idx == arr.length) return 0;

        if(dp[idx][prev_idx + 1] != -1) return dp[idx][prev_idx + 1];

        int len = lengthOfLIS(idx + 1, prev_idx, arr, dp);
        if(prev_idx == -1 || arr[idx] > arr[prev_idx]) {
            len = Math.max(len, 1 + lengthOfLIS(idx + 1, idx, arr, dp));
        }

        return dp[idx][prev_idx + 1] = len;
    }

    // Tabulation Approach
    public static int lenOfLIS(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxlen = 0;
        for(int i = 0; i < n; i++) {
            for(int prev_idx = 0; prev_idx < i; prev_idx++) {
                if(arr[prev_idx] < arr[i] && 1 + dp[prev_idx] > dp[i]){
                    dp[i] = 1 + dp[prev_idx];
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        int n = arr.length;

        int[][] dp = new int[n][n + 1];
        for(int[] d : dp) Arrays.fill(d, -1);

        int ans = lengthOfLIS(0, -1, arr, dp);
        System.out.println(ans);

        System.out.println("Maximum length is: " + lenOfLIS(arr, n));
    }
}
