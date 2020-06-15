/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] numsCopy = new int[nums.length + 2];
        numsCopy[0] = 1;
        numsCopy[numsCopy.length-1] = 1;
        System.arraycopy(nums, 0, numsCopy, 1, nums.length);
        int[][] dp = new int[numsCopy.length][numsCopy.length];
        for (int i = numsCopy.length-2; i >=0; i--) {
            for (int j = i+1; j < numsCopy.length; j++) {
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                        dp[i][k]+dp[k][j]+numsCopy[i]*numsCopy[k]*numsCopy[j]);
                }
            }
        }
        return dp[0][numsCopy.length-1];
    }
}
// @lc code=end

