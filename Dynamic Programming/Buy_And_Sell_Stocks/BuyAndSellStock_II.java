public class BuyAndSellStock_II {

    // Memoization Code
    // Time Complexity -> O(N*2) where N is the length of the array.
    // Space Complexity -> O(N*2) + O(N) where N is the length of the array.
    public static int maxProfit(int[] prices, int idx, int buy, int[][] dp) {
        if(idx == prices.length) return 0;
        int profit = 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        if(buy == 1){
            int buyProfit = maxProfit(prices, idx + 1, 0, dp) - prices[idx];
            int notBuyProfit = maxProfit(prices, idx + 1, 1, dp);
            profit = Math.max(buyProfit, notBuyProfit);
        }
        else{
            int sellProfit = maxProfit(prices, idx + 1, 1, dp) + prices[idx];
            int notSellProfit = maxProfit(prices, idx + 1, 0, dp);
            profit = Math.max(sellProfit, notSellProfit);
        }
        
        return dp[idx][buy] = profit;
    }

    public static void main(String[] args) {
        // Infinite number of transactions are allowed.
        int[] prices = {7, 1, 5, 3, 6, 4};

        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        System.out.println("Maximum profit is: " + maxProfit(prices, 0, 1, dp));
    }
}
