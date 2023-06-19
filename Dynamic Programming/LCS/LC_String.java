public class LC_String {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GTXAB";

        int n = s1.length();
        int m = s2.length();

        // Tabulation Approach
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.println(ans);
    }
}
