package LCS;
public class MinInsertions_To_MakeStringPalindrome {

    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "bbabcbcab";
        // We reversed the string s and stored it in t
        String t = new StringBuilder(s).reverse().toString();

        int ans = s.length() - lcs(s, t);

        System.out.println(ans);
    }
}
