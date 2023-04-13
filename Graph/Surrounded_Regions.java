package Graph;

// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
public class Surrounded_Regions {

    // DFS
    public static void dfs(char[][] board, int[][] visited, int row, int col){
        int n = board.length;
        int m = board[0].length;

        visited[row][col] = 1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && visited[nrow][ncol] == 0){
                dfs(board, visited, nrow, ncol);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];

        for(int j = 0; j < m; j++){
            // top row
            if(board[0][j] == 'O' && visited[0][j] == 0){
                dfs(board, visited, 0, j);
            }

            // bottom row
            if(board[n-1][j] == 'O' && visited[n-1][j] == 0){
                dfs(board, visited, n-1, j);
            }
        }

        for(int i = 0; i < n; i++){
            // left column
            if(board[i][0] == 'O' && visited[i][0] == 0){
                dfs(board, visited, i, 0);
            }

            // right column
            if(board[i][m-1] == 'O' && visited[i][m-1] == 0){
                dfs(board, visited, i, m-1);
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }

        // print board
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
