import java.util.Arrays;

public class Edit_Distance {
    public static int editDistance(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = editDistance(i - 1, j - 1, s1, s2, dp);
        }
        else {
            return dp[i][j] = 1 + Math.min(editDistance(i, j - 1, s1, s2, dp), 
                        Math.min(editDistance(i - 1, j, s1, s2, dp), 
                                editDistance(i - 1, j - 1, s1, s2, dp)));
        }
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        int ans = editDistance(n - 1, m - 1, s1, s2, dp);

        System.out.println("Minimum operations required are: " + ans);
    }
}
