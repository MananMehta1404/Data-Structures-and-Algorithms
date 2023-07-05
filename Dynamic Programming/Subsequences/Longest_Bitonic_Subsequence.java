import java.util.Arrays;

public class Longest_Bitonic_Subsequence {

    public static int findLen(int[] arr, int n) {
        // Increasing Subsequence from 0 -> n
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        for(int i = 0; i < n; i++) {
            for(int prev_idx = 0; prev_idx < i; prev_idx++) {
                if(arr[prev_idx] < arr[i] && 1 + dp1[prev_idx] > dp1[i]){
                    dp1[i] = 1 + dp1[prev_idx];
                }
            }
        }

        // Increasing Subsequence from n - 1 -> 0
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        for(int i = n - 1; i >= 0; i--) {
            for(int prev_idx = n - 1; prev_idx > i; prev_idx--) {
                if(arr[prev_idx] < arr[i] && 1 + dp2[prev_idx] > dp2[i]){
                    dp2[i] = 1 + dp2[prev_idx];
                }
            }
        }

        int maxlen = 0;
        for(int i = 0; i < n; i++){
            maxlen = Math.max(maxlen, dp1[i] + dp2[i] - 1);
        }

        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;

        int ans = findLen(arr, n);
        System.out.println("Longest Bitonic Subsequence is of length: " + ans);
    }
}
