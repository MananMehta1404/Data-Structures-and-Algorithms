package Arrays;

public class Island_Peri {

    // Each block will have 4 sides. We will return the number of sides with water touching it by counting the number of lands and then subtracting it from 4.
    public static int findWater(int row, int col, int[][] grid, int[] delRow, int[] delCol){
        int land = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1){
                land++;
            }
        }

        return 4 - land;
    }

    public static void main(String[] args) {

        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int ans = 0;

        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ans += findWater(i, j, grid, delRow, delCol);
                }
            }
        }

        System.out.println("The perimeter of the island is: " + ans);
    }
}
