import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

    static class Pair {
        int row, col, steps;

        Pair (int r, int c, int s) {
            row = r;
            col = c;
            steps = s;
        }
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int row = entrance[0];
        int col = entrance[1];

        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col, 0));
        vis[row][col] = 1;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.peek();
            q.remove();

            int r = p.row;
            int c = p.col;
            int steps = p.steps;

            if(steps != 0) {
                for(int i = 0; i < 4; i++) {
                    int nr = r + delrow[i];
                    int nc = c + delcol[i];

                    if(nr >= n || nr < 0 || nc >= m || nc < 0) return steps;
                }
            }

            for(int i = 0; i < 4; i++) {
                int nr = r + delrow[i];
                int nc = c + delcol[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] == '.' && vis[nr][nc] != 1){
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc, steps + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1, 2};

        System.out.println(nearestExit(maze, entrance));
    }
}
