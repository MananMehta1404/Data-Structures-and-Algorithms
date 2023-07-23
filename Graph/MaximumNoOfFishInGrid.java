import java.util.LinkedList;
import java.util.Queue;

public class MaximumNoOfFishInGrid {

    static class Pair {
        int row, col;

        Pair(int _row, int _col) {
            this.row = _row;
            this.col = _col;
        }
    }

    public static boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static int bfs(int row, int col, int[][] grid, int[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        int fish = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            fish += grid[r][c];
            for(int i = 0; i < 4; i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];

                if(isValid(nrow, ncol, n, m) && grid[nrow][ncol] != 0 && vis[nrow][ncol] != 1) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        return fish;
    }

    public static int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        int maxFish = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0 && vis[i][j] != 1) {
                    int fish = bfs(i, j, grid, vis);
                    if(maxFish < fish) maxFish = fish;
                }
            }
        }

        return maxFish;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 1}
        };

        System.out.println(findMaxFish(grid));
    }
}
