import java.util.Arrays;

public class No_Of_LIS {
    public static int findNoOFLIS(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        int maxlen = 0;
        for(int i = 0; i < n; i++) {
            for(int prev_idx = 0; prev_idx < i; prev_idx++) {
                if(arr[prev_idx] < arr[i] && 1 + dp[prev_idx] > dp[i]){
                    dp[i] = 1 + dp[prev_idx];
                    cnt[i] = cnt[prev_idx];
                }
                else if(arr[prev_idx] < arr[i] && 1 + dp[prev_idx] == dp[i]) {
                    cnt[i] += cnt[prev_idx];
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }

        int nos = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == maxlen) nos += cnt[i];
        }

        return nos;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        int n = arr.length;

        int no = findNoOFLIS(arr, n);
        System.out.println("Number of LIS are: " + no);
    }
}
