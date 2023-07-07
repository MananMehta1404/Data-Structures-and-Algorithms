public class Unique_Paths_I {
    // Time Complexity -> O(2^(x+y))
    public static int countPaths(int i, int j, int x, int y, int[][] dp) {
        // Base Case -> If we either reach end of row or column we return 1 because that is one path.
        if(i == x - 1 || j == y - 1) return 1;

        if(dp[i][j] != 0) return dp[i][j];
        // Otherwise we increase one row or one column and return the sum of them.
        return dp[i][j] = countPaths(i + 1, j, x, y, dp) + countPaths(i, j + 1, x, y, dp);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int[][] dp = new int[m][n];
        int ans = countPaths(0, 0, m, n, dp);

        System.out.println("Number of unique paths are: " + ans);
    }
}