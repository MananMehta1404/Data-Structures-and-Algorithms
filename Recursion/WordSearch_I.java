public class WordSearch_I {

    public static boolean doesExist(int row, int col, char[][] board, int idx, String word, int[][] visited) {

        boolean ans = false;
        
        if(word.charAt(idx) == board[row][col]) {
            visited[row][col] = 1;
            if(idx == word.length() - 1) return true;

            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length) {
                    if(visited[nRow][nCol] == 1) continue;
                    ans = ans || doesExist(nRow, nCol, board, idx + 1, word, visited);
                }

            }
        }

        visited[row][col] = 0;
        
        return ans;
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int[][] visited = new int[n][m];
                boolean ans = doesExist(i, j, board, 0, word, visited);
                if(ans == true) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String word = "abdc";

        System.out.println(exist(board, word));
    }
}
