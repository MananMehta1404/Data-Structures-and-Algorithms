import java.util.Arrays;

public class Minimum_Falling_Path_Sum_II {

    // Memoization Approach
    public static int findMinPathSum(int row, int col, int[][] arr, int n, int m, int[][] dp) {
        if(row == n - 1) return arr[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(i == col) continue;
            int sum = findMinPathSum(row + 1, i, arr, n, m, dp);
            if(minSum > sum) minSum = sum;
        }

        return dp[row][col] = minSum + arr[row][col];
    }
    
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        int n = arr.length;
        int m = arr[0].length;

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Memoization Approach
        // int minSum = Integer.MAX_VALUE;
        // for(int i = 0; i < m; i++) {
        //     int sum = findMinPathSum(0, i, arr, n, m, dp);
        //     System.out.println("Sum for column " + i + " is: " + sum);

        //     if(minSum > sum) minSum = sum;
        // }

        // Tabulation Approach
        for(int j = 0; j < n; j++) dp[n - 1][j] = arr[n - 1][j];

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int minVal = (int)(1e9);
                for(int k = 0; k < n; k++) {
                    if(k == j) continue;
                    minVal = Math.min(minVal, dp[i + 1][k]);
                }
                
                dp[i][j] = arr[i][j] + minVal;
            }
        }

        int minSum = (int)(1e9);
        for(int j = 0; j < n; j++) {
            if(minSum > dp[0][j]) minSum = dp[0][j];
        }

        System.out.println("Minimum sum is: " + minSum);
    }
}
