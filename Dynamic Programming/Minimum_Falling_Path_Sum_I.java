import java.util.Arrays;

public class Minimum_Falling_Path_Sum_I {

    // Memoization Approach
    public static int findMinPathSum(int row, int col, int[][] arr, int n, int m, int[][] dp) {
        if(row == n - 1) return arr[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int[] delcol = {-1, 0, 1};
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            int ncol = col + delcol[i];
            if(ncol < 0 || ncol >= m) continue;
            int sum = findMinPathSum(row + 1, ncol, arr, n, m, dp);
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
                int down = dp[i + 1][j];
                int left = (int)(1e9);
                int right = (int)(1e9);
                if(j - 1 >= 0) left = dp[i + 1][j - 1];
                if(j + 1 < n) right = dp[i + 1][j + 1];

                dp[i][j] = arr[i][j] + Math.min(down, Math.min(left, right));
            }
        }

        int minSum = (int)(1e9);
        for(int j = 0; j < n; j++) {
            if(minSum > dp[0][j]) minSum = dp[0][j];
        }

        System.out.println("Minimum sum is: " + minSum);
    }
}
