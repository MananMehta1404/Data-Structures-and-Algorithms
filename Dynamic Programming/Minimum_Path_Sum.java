package Dynamic_Programming;

public class Minimum_Path_Sum {

    // Memoization Code
    public static int minPathSum(int[][] grid, int row, int col, int[][] dp){
        
        // Base Case
        if(row == grid.length - 1 && col == grid[0].length - 1){
            return grid[row][col];
        }

        if(dp[row][col] != -1) return dp[row][col];

        int sum = 0;

        if(row == grid.length - 1){
            sum = grid[row][col] + minPathSum(grid, row, col + 1, dp);
        }
        else if(col == grid[0].length - 1){
            sum = grid[row][col] + minPathSum(grid, row + 1, col, dp);
        }
        else{
            int down = minPathSum(grid, row + 1, col, dp);
            int right = minPathSum(grid, row, col + 1, dp);
            sum = Math.min(down, right) + grid[row][col];
        }

        return dp[row][col] = sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println("Minimum Path Sum is: " + minPathSum(grid, 0, 0, dp));
    }
}
