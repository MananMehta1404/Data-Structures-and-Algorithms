public class SudokuSolver{

    public static boolean isSafe(char[][] board, int row, int col, int num){
        for(int i = 0; i < board.length; i++){
            // Vertical Check
            if(board[i][col] == (char)(num + '0')) return false;
            // Horizontal Check
            if(board[row][i] == (char)(num + '0')) return false;
        }

        // 3 x 3 Grid Check
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(board[i][j] == (char)(num + '0')) return false;
            }
        }

        return true;
    }

    public static boolean helper(char[][] board, int row, int col){
        // Base Case
        if(row == board.length) return true;

        int nrow = 0;
        int ncol = 0;

        if(col == board.length - 1){
            ncol = 0;
            nrow = row + 1;
        }
        else{
            ncol = col + 1;
            nrow = row;
        }

        if(board[row][col] != '.'){
            if(helper(board, nrow, ncol)) return true;
        }
        else{
            for(int i = 1; i <= 9; i++){
                if(isSafe(board, row, col, i)){
                    board[row][col] = (char)(i + '0');
                    if(helper(board, nrow, ncol)) return true;
                    else board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public static void printBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};

        printBoard(board);
        helper(board, 0, 0);
        printBoard(board);
    }
}