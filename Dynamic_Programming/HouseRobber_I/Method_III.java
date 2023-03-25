package Dynamic_Programming.HouseRobber_I;

public class Method_III {
    // Space Optimization Method
    public static void main(String[] args) {
        int nums[] = {2, 1, 6, 9};
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < n; i++) {
            int rob = nums[i];
            if(i > 1) rob += prev2;
            int notRob = prev;

            int curr = Math.max(rob, notRob);

            prev2 = prev;
            prev = curr;
        }

        System.out.println("Maximum amount of money that can be robbed is: " + prev);
    }
}
