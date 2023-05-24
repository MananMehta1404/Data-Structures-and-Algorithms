public class SpiralMatrix_II {

    // Time Complexity: O(n*m)
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;

        int val = 1;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                matrix[top][i] = val;
                val++;
            }
            top++;

            for(int i = top; i <= bottom; i++){
                matrix[i][right] = val;
                val++;
            }
            right--;

            if(top <= bottom) {
                for(int i = right; i >= left; i--){
                    matrix[bottom][i] = val;
                    val++;
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    matrix[i][left] = val;
                    val++;
                }
                left++;
            }
        }

        return matrix;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = generateMatrix(n);

        // Print the matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
