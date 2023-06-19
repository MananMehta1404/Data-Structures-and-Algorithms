public class LCS {

    // Memoization Approach
    public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + lcs(s1, s2, i-1, j-1, dp);

        return dp[i][j] = Math.max(lcs(s1, s2, i-1, j, dp), lcs(s1, s2, i, j-1, dp));
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int n = s1.length();
        int m = s2.length();

        // int[][] dp = new int[n][m];
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        
        // int ans = lcs(s1, s2, n - 1, m - 1, dp);
        // System.out.println(ans);

        // Tabulation Approach
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[n][m]);
    }
}