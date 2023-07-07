import java.util.Arrays;

public class Ninjas_Training {
    // Memoization Approach
    public static int findMaxPoints(int idx, int last, int[][] arr, int[][] dp) {
        if(idx == 0) {
            int maxres = 0;
            for(int i = 0; i < 3; i++) {
                if(i != last) maxres = Math.max(maxres, arr[idx][i]);
            }
            return maxres;
        }

        if(dp[idx][last] != -1) return dp[idx][last];

        int res = 0;
        for(int i = 0; i < 3; i++) {
            if(i != last) {
                int points = arr[idx][i] + findMaxPoints(idx - 1, i, arr, dp);
                res = Math.max(res, points);
            }
        }

        return dp[idx][last] = res;
    }

    // Tabulation Approach
    public static int findMaxPoints1(int[][] arr, int n, int[][] dp) {
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for(int day = 1; day < n; day++) {
            for(int last = 0; last < 4; last++) {
                for(int task = 0; task < 3; task++) {
                    if(task != last) {
                        int points = arr[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], points);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 3}, {3, 4, 6}, {10, 1, 6}, {8, 3, 7}};
        int n = arr.length;

        int[][] dp = new int[n][4];
        for(int[] row: dp) Arrays.fill(row, -1);

        // int maxPoints = findMaxPoints(n - 1, 3, arr, dp);
        int maxPoints = findMaxPoints1(arr, n, dp);

        System.out.println(maxPoints);
    }
}
