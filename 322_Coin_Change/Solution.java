class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i ++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// Runtime: 19ms

