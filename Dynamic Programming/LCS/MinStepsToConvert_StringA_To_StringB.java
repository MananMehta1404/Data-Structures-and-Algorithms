package LCS;
public class MinStepsToConvert_StringA_To_StringB {

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
        String A = "abcd";
        String B = "anc";

        int lengthLCS = lcs(A, B);

        int ans = A.length() + B.length() - 2 * lengthLCS;
        System.out.println(ans);
    }
}
