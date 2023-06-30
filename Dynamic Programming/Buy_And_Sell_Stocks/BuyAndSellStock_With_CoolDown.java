public class BuyAndSellStock_With_CoolDown {
    // Memoization Code  
    public static int max_Profit(int[] prices, int idx, int buy, int[][] dp){
        if(idx >= prices.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;

        if(buy == 1){
            int buyProfit = max_Profit(prices, idx + 1, 0, dp) - prices[idx];
            int notBuyProfit = max_Profit(prices, idx + 1, 1, dp);
            profit = Math.max(buyProfit, notBuyProfit);
        }
        else{
            int sellProfit = max_Profit(prices, idx + 2, 1, dp) + prices[idx];
            int notSellProfit = max_Profit(prices, idx + 1, 0, dp);
            profit = Math.max(sellProfit, notSellProfit);
        }

        return dp[idx][buy] = profit;
    }

    public static void main(String[] args) {
        // There is a cooldown of 1 day after you sell a stock i.e you cannot buy a stock on the next day after you sell a stock.
        int[] prices = {1, 2, 3, 0, 2};

        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        System.out.println("Maximum profit gained is: " + max_Profit(prices, 0, 1, dp));
    }

}
