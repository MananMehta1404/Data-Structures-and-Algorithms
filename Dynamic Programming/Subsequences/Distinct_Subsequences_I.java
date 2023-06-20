public class Distinct_Subsequences_I {

    // Memoization Approach
    public static int fun(int i, int j, String s, String t, int[][] dp) {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = fun(i - 1, j - 1, s, t, dp) + fun(i - 1, j, s, t, dp);
        } else {
            return dp[i][j] = fun(i - 1, j, s, t, dp);
        }
    }
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        int n = s.length();
        int m = t.length();

        // int[][] dp = new int[n][m];
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) dp[i][j] = -1;
        // }

        // int ans = fun(n - 1, m - 1, s, t, dp);
        // System.out.println(ans);

        // Tabulation Approach
        int[][] dp = new int[n + 1][m + 1];

        // Base Cases
        for(int i = 0; i <= n; i++) dp[i][0] = 1;
        for(int j = 1; j <= m; j++) dp[0][j] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } 
                else dp[i][j] = dp[i - 1][j];
            }
        }

        int ans = dp[n][m];
        System.out.println(ans);
    }
}
