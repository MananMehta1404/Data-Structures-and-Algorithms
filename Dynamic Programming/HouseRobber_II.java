public class HouseRobber_II {

    public static int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < n; i++){
            int rob = nums[i];
            if(i > 1) rob += prev2;
            int notRob = prev;

            int curr = Math.max(rob, notRob);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 6, 9};
        int n = nums.length;
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];
        int j = 0;
        int k = 0;

        for(int i = 0; i < n; i++){
            if(i != 0) {
                temp1[j] = nums[i];
                j++;
            }
            if(i != n - 1) {
                temp2[k] = nums[i];
                k++;
            }
        }

        int money = Math.max(rob(temp1), rob(temp2));

        System.out.println("Maximum amount of money that can be robbed is: " + money);
    }
}
