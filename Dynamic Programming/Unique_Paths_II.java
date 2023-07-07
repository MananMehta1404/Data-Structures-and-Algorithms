public class Unique_Paths_II {
    // Time Complexity -> O(2^(x+y))
    public static int countPaths(int[][] obstacleGrid, int i, int j, int x, int y, int[][] dp){
        // Base Case -> If we either reach end of row or column we return 1 because that is one path.
        if(i >= x || j >= y) return 0;
        if(obstacleGrid[i][j] == 1) return dp[i][j] = 0;
        if(i == x - 1 && j == y - 1) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        // Otherwise we increase one row or one column and return the sum of them.
        return dp[i][j] = countPaths(obstacleGrid, i + 1, j, x, y, dp) + countPaths(obstacleGrid, i, j + 1, x, y, dp);
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        int ans = countPaths(obstacleGrid, 0, 0, m, n, dp);

        System.out.println("Number of Unique Paths: " + ans);
    }
}
