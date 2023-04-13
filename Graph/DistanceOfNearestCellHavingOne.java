package Graph;

import java.util.*;

// Time Complexity: O(n*m) where n is the number of rows and m is the number of columns
// Space Complexity: O(n*m) where n is the number of rows and m is the number of columns
public class DistanceOfNearestCellHavingOne {

    // Node class to store the row, column and steps
    static class Node{
        int first;
        int second;
        int steps;

        Node(int first, int second, int steps){
            this.first = first;
            this.second = second;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}};

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Node> q = new LinkedList<Node>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    visited[i][j] = 1;
                    q.add(new Node(i, j, 0));
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // BFS
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().steps;
            q.remove();
            
            dist[row][col] = steps;

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0){
                    visited[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        // Print the distance matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
