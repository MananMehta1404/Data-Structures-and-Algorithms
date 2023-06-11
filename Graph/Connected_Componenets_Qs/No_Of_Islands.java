import java.util.*;

public class No_Of_Islands {

    public static void bfs(int row, int col, char[][] grid, boolean[][] visited){
        visited[row][col] = true;

        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new LinkedList<Integer>() {{
            add(row);
            add(col);
            }} );

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int ro = (int)q.peek().get(0);
            int co = (int)q.peek().get(1);
            q.remove();

            for(int delrow = -1; delrow <= 1; delrow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    if(delrow == delcol) continue;
                    if(delrow + delcol == 0) continue;
                    int nrow = ro + delrow;
                    int ncol = co + delcol;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !visited[nrow][ncol]){
                        visited[nrow][ncol] = true;
                        q.add(new LinkedList<Integer>() {{
                            add(nrow);
                            add(ncol);
                            }} );
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        }

        System.out.println("No. of islands is: " + count);
    }
}
