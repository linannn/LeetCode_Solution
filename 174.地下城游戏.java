/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        int row = dungeon.length - 1;
        int col = dungeon[0].length - 1;
        int[][] dp = new int[row+1][col+1];
        dp[row][col] = Math.min(dungeon[row][col], 0);
        for (int i = row-1; i >= 0; i--) {
            int tmp = dp[i + 1][col] + dungeon[i][col];
            dp[i][col] = Math.min(tmp, 0);
        }
        for (int i = col - 1; i >= 0; i--) {
            int tmp = dp[row][i + 1] + dungeon[row][i];
            dp[row][i] = Math.min(tmp, 0);
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col-1; j >= 0 ; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], 0), Math.min(dp[i][j + 1], 0)) + dungeon[i][j];
            }
        }
        return -Math.min(0, dp[0][0]) + 1;
    }
}
// @lc code=end

