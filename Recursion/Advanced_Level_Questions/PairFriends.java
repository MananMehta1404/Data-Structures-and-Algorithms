package Recursion.Advanced_Level_Questions;

public class PairFriends {
    public static int pairFriends(int n){
        if(n <= 1) return 1;
        return pairFriends(n - 1) + (n - 1) * pairFriends(n - 2);
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(pairFriends(n));
    }
    
}
