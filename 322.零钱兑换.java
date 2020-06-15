/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
//     Integer[] coins;
//     int res = Integer.MAX_VALUE;
//     public int coinChange(int[] coins, int amount) {
//         this.coins = new Integer[coins.length];
//         for (int i = 0; i < coins.length; i++) 
//             this.coins[i] = coins[i];
//         coin(amount, 0, 0);
//         return res == Integer.MAX_VALUE ? -1 : res;
//     }
//     private void coin(int amount, int idx, int count) {
//         if (amount == 0) {
//             res = Math.min(res, count);
//             return;
//         }
//         if (idx == coins.length) {
//             return;
//         }
//         for (int k = amount / coins[idx]; k >= 0; k--) {
//             coin(amount - k * coins[idx], idx + 1, count + k);
//         }
//     }
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        if (amount == 0)
            return 0;
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int c: coins) {
                if (i - c >= 0 && dp[i - c] != -1)
                    min = Math.min(dp[i-c]+1, min);
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }
}
// @lc code=end

