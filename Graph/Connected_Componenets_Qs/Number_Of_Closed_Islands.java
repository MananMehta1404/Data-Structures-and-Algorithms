import java.util.*;

// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
public class Number_Of_Closed_Islands {

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void dfs(int[][] grid, int[][] visited, int row, int col){
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = 1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && visited[nrow][ncol] == 0){
                dfs(grid, visited, nrow, ncol);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},
                        {1,0,0,0,0,1,1,0},
                        {1,0,1,0,1,1,1,0},
                        {1,0,0,0,0,1,0,1},
                        {1,1,1,1,1,1,1,0}};

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        // Add all 0's on the boundary to the queue
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // If the current element is 1 and it is on the boundary
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1){
                    if(grid[i][j] == 0){
                        q.add(new Pair(i, j));
                        visited[i][j] = 1;
                    }
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // BFS
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && visited[nrow][ncol] == 0){
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && visited[i][j] == 0){
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        System.out.println("Number of Closed Islands are: " + count);
    }
}
