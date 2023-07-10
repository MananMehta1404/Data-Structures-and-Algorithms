import java.util.Arrays;

public class MaximumLength_PairChain {
    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int n = pairs.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxlen = 1;
        for(int i = 0; i < n; i++) {
            for(int prev_idx = 0; prev_idx < i; prev_idx++) {
                if(pairs[prev_idx][1] < pairs[i][0] && 1 + dp[prev_idx] > dp[i]) {
                    dp[i] = 1 + dp[prev_idx];
                }
            }

            maxlen = Math.max(maxlen, dp[i]);
        }

        System.out.println("Maximum Length of Chain is: " + maxlen);
    }
}
