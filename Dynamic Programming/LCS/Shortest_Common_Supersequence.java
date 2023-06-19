public class Shortest_Common_Supersequence {

    public static void main(String[] args) {
        String s = "brute";
        String t = "groot";

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

        int lengthLCS = dp[n][m];
        int lengthOf_SuperSeq = s.length() + t.length() - lengthLCS;

        System.out.println(lengthOf_SuperSeq);

        String ans = "";
        int i = n, j = m;
        while(i > 0 && j > 0) {
            if(s.charAt(i - 1) == t.charAt(j - 1)) {
                ans = s.charAt(i - 1) + ans;
                i--;
                j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]) {
                    ans = s.charAt(i - 1) + ans;
                    i--;
                }
                else {
                    ans = t.charAt(j - 1) + ans;
                    j--;
                }
            }
        }

        while(i > 0) {
            ans = s.charAt(i - 1) + ans;
            i--;
        }
        while(j > 0) {
            ans = t.charAt(j - 1) + ans;
            j--;
        }

        System.out.println(ans);
    }
}
