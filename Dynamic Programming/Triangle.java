import java.util.*;

public class Triangle {

    public static int minPath(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(row == triangle.size() - 1) return triangle.get(row).get(col);

        if(dp[row][col] != -1) return dp[row][col];

        int case1 = minPath(triangle, row + 1, col, dp);
        int case2 = minPath(triangle, row + 1, col + 1, dp);
        
        return dp[row][col] = triangle.get(row).get(col) + Math.min(case1, case2);
    }

    public static void main(String[] args) {
        int[][] arr = {{2}, {3,4}, {6,5,7}, {4,1,8,3}};
        
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < arr[i].length; j++){
                temp.add(arr[i][j]);
            }
            triangle.add(temp);
        }

        int n = triangle.size();

        int[][] dp = new int[n][];
        for(int i = 0; i < n; i++) {
            int size = triangle.get(i).size();
            dp[i] = new int[size];
            Arrays.fill(dp[i], -1);
        }

        int ans = minPath(triangle, 0, 0, dp);

        System.out.println("Minimum Path Sum: " + ans);
    }
}
