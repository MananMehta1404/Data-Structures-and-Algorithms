import java.util.*;

public class Number_Of_Distinct_Islands {

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString(){
            return this.first + " " + this.second;
        }
    }

    public static void dfs(int[][] grid, int[][] visited, int row, int col, List<String> list, int row0, int col0){
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = 1;
        list.add(new Pair(row - row0, col - col0).toString());

        int[] delRow = {0, 0, 1, -1};
        int[] delCol = {1, -1, 0, 0};

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0){
                dfs(grid, visited, nrow, ncol, list, row0, col0);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, 
                        {1, 0, 0, 0, 0}, 
                        {0, 0, 0, 0, 1}, 
                        {1, 1, 0, 1, 1}};

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(grid, visited, i, j, list, i, j);
                    set.add(list);
                }
            }
        }

        System.out.println(set.toString());

        System.out.println("Number of distinct islands: " + set.size());
    }
}
