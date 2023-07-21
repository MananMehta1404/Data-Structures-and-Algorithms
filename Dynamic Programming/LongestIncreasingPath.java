import java.util.Arrays;

public class LongestIncreasingPath {

    public static int dfs(int row, int col, int[][] mat, int n, int m, int[][] vis, int[][] dp) {
        vis[row][col] = 1;

        if(dp[row][col] != -1) return dp[row][col];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int steps = 1;
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && mat[nrow][ncol] > mat[row][col]) {
                steps = Math.max(steps, 1 + dfs(nrow, ncol, mat, n, m, vis, dp));
            }
        }

        return dp[row][col] = steps;
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, -1);
        int[][] vis = new int[n][m];

        int max = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] != 1) {
                    dfs(i, j, matrix, n, m, vis, dp);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};

        int ans = longestIncreasingPath(matrix);
        System.out.println(ans);
    }
}
