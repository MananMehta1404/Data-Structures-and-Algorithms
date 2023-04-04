package Graph;

public class Flood_Fill {

    public static void dfs(int row, int col, int[][] ans, int[][] image, int iniColor, int color, int[] delRow, int[] delCol){

        ans[row][col] = color;

        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != color){
                dfs(nrow, ncol, ans, image, iniColor, color, delRow, delCol);
            }
        }
    }
    
    public static void main(String[] args) {

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        // Initial Image
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, iniColor, color, delRow, delCol);

        // Printing the answer
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
