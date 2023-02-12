package Dynamic_Programming;

public class BuyAndSellStock_I {

    // Time Complexity -> O(N) where N is the length of the array.
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            int temp = prices[i] - min;
            if(min > prices[i]) min = prices[i];
            if(profit < temp) profit = temp;
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit is: " + maxProfit(prices));
    }
}
