package Recursion.Backtracking;

import java.util.*;;

public class N_Queens {

    public static void saveBoard(char[][] board, List<List<String>> allBoards){
        List<String> newBoard = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            String row = "";
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'Q') row += 'Q';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    public static boolean isSafe(int row, int col, char[][] board){
        // Horizontal Check
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == 'Q') return false;
        }

        // Vertical Check
        for(int i = 0 ; i < board.length; i++){
            if(board[i][col] == 'Q') return false;
        }

        // Upper-Left Check
        for(int r = row, c = col; r >= 0 && c >= 0; r--, c--){
            if(board[r][c] == 'Q') return false;
        }

        // Upper-Right Check
        for(int r = row, c = col; r >= 0 && c < board.length; r--, c++){
            if(board[r][c] == 'Q') return false;
        }

        // Lower-Left Check
        for(int r = row, c = col; r < board.length && c >= 0; r++, c--){
            if(board[r][c] == 'Q') return false;
        }

        // Lower-Right Check
        for(int r = row, c = col; r < board.length && c < board.length; r++, c++){
            if(board[r][c] == 'Q') return false;
        }

        return true;
    }

    public static void helper(char[][] board, List<List<String>> allBoards, int col){
        // Base Case
        if(col == board.length){
            saveBoard(board, allBoards);
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allBoards, 0);
        return allBoards;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
