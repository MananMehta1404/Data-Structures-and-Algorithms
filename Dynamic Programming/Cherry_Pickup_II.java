import java.util.Arrays;

public class Cherry_Pickup_II {
    public static int findMax(int row, int col1, int col2, int[][] grid, int n, int m, int[][][] dp) {
        if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return (int)(-1e9);
        if(row == n - 1) {
            if(col1 == col2) return grid[row][col1];
            else return grid[row][col1] + grid[row][col2];
        }

        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int max = 0;
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(col1 == col2) max = Math.max(max, grid[row][col1] + findMax(row + 1, col1 + i, col2 + j, grid, n, m, dp));
                else max = Math.max(max, grid[row][col1] + grid[row][col2] + findMax(row + 1, col1 + i, col2 + j, grid, n, m, dp));
            }
        }

        return dp[row][col1][col2] = max;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for(int[][] row: dp) {
            for(int[] col1: row) {
                Arrays.fill(col1, -1);
            }
        }

        int ans = findMax(0, 0, m - 1, grid, n, m, dp);

        System.out.println("Maximum number of cherries collected is: " + ans);
    }
}