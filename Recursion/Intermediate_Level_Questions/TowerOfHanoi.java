package Recursion.Intermediate_Level_Questions;

public class TowerOfHanoi {
    
    public static void towerOfHanoi(int n, String source, String helper, String destination){
        if(n == 1){
            System.out.println("Transfer of disk" + n + " from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, helper);
        System.out.println("Transfer of disk" + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, helper, source, destination);
    }
    
    public static void main(String[] args) {
        int n = 4;
        towerOfHanoi(n, "A", "B", "C");
    }
}
