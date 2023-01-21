package Recursion.Advanced_Level_Questions;

public class CountPathMaze {

    // Time Complexity -> O(2^(x+y))
    public static int countPaths(int i, int j, int x, int y){
        // Base Case -> If we either reach end of row or column we return 1 because that is one path.
        if(i == x - 1 || j == y - 1) return 1;
        // Otherwise we increase one row or one column and return the sum of them.
        else return countPaths(i + 1, j, x, y) + countPaths(i, j + 1, x, y);
    }

    public static void main(String[] args) {
        int x = 3, y = 3;
        System.out.println(countPaths(0, 0, x, y));   
    }
}
