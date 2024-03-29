public class BuyAndSellStock_IV {
    // Memoization Code
    // Time Complexity -> O(N*2*K) where N is the length of the array and K is the number of transactions allowed.
    // Space Complexity -> O(N*2*K) + O(N) where N is the length of the array and K is the number of transactions allowed.
    public static int max_Profit(int[] prices, int idx, int buy, int cap, int[][][] dp) {
        if(idx == prices.length || cap == 0) return 0;
        int profit = 0;

        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

        if(buy == 1){
            int buyProfit = max_Profit(prices, idx + 1, 0, cap, dp) - prices[idx];
            int notBuyProfit = max_Profit(prices, idx + 1, 1, cap, dp);
            profit = Math.max(buyProfit, notBuyProfit);
        }
        else{
            int sellProfit = max_Profit(prices, idx + 1, 1, cap - 1, dp) + prices[idx];
            int notSellProfit = max_Profit(prices, idx + 1, 0, cap, dp);
            profit = Math.max(sellProfit, notSellProfit);
        }
        
        return dp[idx][buy][cap] = profit;
    }

    public static void main(String[] args) {
        // At most k transactions are allowed.
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 3;

        int[][][] dp = new int[prices.length][2][k + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < 2; j++){
                for(int l = 0; l < k + 1; l++){
                    dp[i][j][l] = -1;
                }
            }
        }

        System.out.println("Maximum profit gained is: " + max_Profit(prices, 0, 1, k, dp));
    }
}
