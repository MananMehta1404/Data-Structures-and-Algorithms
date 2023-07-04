import java.util.Arrays;
public class Wildcard_Matching {

    public static int doesMatch(int i, int j, String pattern, String text, int[][] dp) {
        if(i < 0 && j < 0) return 1;
        if(i < 0) return 0;
        if(j < 0) {
            for(int k = 0; k <= i; k++) {
                if(pattern.charAt(k) != '*') return 0;
            }
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            return dp[i][j] = doesMatch(i - 1, j - 1, pattern, text, dp);
        }
        else if(pattern.charAt(i) == '*') {
            return dp[i][j] = (doesMatch(i - 1, j, pattern, text, dp) == 1 || doesMatch(i, j - 1, pattern, text, dp) == 1) ? 1 : 0;
        }
        else {
            return dp[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        String pattern = "ab*cd*";
        String text = "abdefcd";

        int n = pattern.length();
        int m = text.length();

        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = doesMatch(n - 1, m - 1, pattern, text, dp);
        System.out.println(ans);
    }
}