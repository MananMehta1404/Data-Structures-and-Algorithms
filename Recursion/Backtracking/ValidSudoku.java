package Recursion.Backtracking;

public class ValidSudoku {

    public static boolean isSafe(char[][] board, int row, int col){

        // Vertical Checking
        for(int i = 0; i < board.length; i++){
            if(i == row) continue;
            if(board[i][col] == board[row][col]){
                return false;
            }
        }

        // Horizontal Checking
        for(int i = 0; i < board.length; i++){
            if(i == col) continue;
            if(board[row][i] == board[row][col]){
                return false;
            }
        }

        // Grid Checking 3x3
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);

        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(i == row && j == col) continue;
                if(board[i][j] == board[row][col]){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValid(char[][] board, int row, int col){

        if(row == board.length) return true;

        int nrow = 0;
        int ncol = 0;
        if(col != board.length - 1){
            ncol = col + 1;
            nrow = row;
        }
        else{
            ncol = 0;
            nrow = row + 1;
        }

        if(board[row][col] == '.'){
            return isValid(board, nrow, ncol);
        }
        else{
            if(isSafe(board, row, col)){
                return isValid(board, nrow, ncol);
            }
            else return false;
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

        boolean valid = isValid(board, 0, 0);
        System.out.println("The validity of board is: " + valid);
    }
}
