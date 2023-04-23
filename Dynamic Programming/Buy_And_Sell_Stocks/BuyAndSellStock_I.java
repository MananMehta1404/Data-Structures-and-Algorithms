package Dynamic_Programming.Buy_And_Sell_Stocks;

public class BuyAndSellStock_I {

    // Time Complexity -> O(N) where N is the length of the array.
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            int temp_Profit = prices[i] - min;
            profit = Math.max(profit, temp_Profit);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }

    public static void main(String[] args) {
        // Single Transaction is allowed.
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit is: " + maxProfit(prices));
    }
}
