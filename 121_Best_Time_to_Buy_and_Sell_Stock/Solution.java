class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }
}

// Runtime: 1ms
// Time: O(n)
// Space: O(1)
