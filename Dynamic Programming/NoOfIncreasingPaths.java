import java.util.Arrays;

public class NoOfIncreasingPaths {

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
                steps += dfs(nrow, ncol, mat, n, m, vis, dp);
                steps %= 1000000007;
            }
        }

        return dp[row][col] = steps % 1000000007;
    }

    public static int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, -1);

        int[][] vis = new int[n][m];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] != 1) {
                    dfs(i, j, grid, n, m, vis, dp);
                }
                sum += dp[i][j];
                sum %= 1000000007;
            }
        }

        return sum % 1000000007;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};

        int ans = countPaths(matrix);
        System.out.println(ans);
    }
}
