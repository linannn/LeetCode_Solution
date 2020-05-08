/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 0; i < l1; i++) {
            dp[i + 1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        for (int i = 0; i < l2; i++) {
            dp[0][i + 1] = dp[0][i] && s2.charAt(i) == s3.charAt(i);
        }
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                    dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[l1][l2];
    }
}
// @lc code=end

