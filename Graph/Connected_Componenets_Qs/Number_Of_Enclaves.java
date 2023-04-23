// Given a 2D array grid, each cell is 0 (representing sea) or 1 (representing land).
// A move consists of walking from one land square (4-directionally) to another land square, or off the boundary of the grid.
// Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.

package Graph.Connected_Componenets_Qs;

import java.util.*;

// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
public class Number_Of_Enclaves {

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        // Add all 1's on the boundary to the queue
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // If the current element is 1 and it is on the boundary
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1){
                    if(grid[i][j] == 1){
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

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0){
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                }
            }
        }

        System.out.println("Number of Enclaves: " + count);
    }
}
