/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len+1][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = true;
            dp[1][i] = true;
        }
        int res = 0;
        for (int i = 2; i < len+1; i++) {
            for (int j = 0; j <len-i+1; j++) {
                dp[i][j] = s.charAt(j) == s.charAt(i+j-1) && dp[i-2][j+1];
                if (dp[i][j])
                    res++;
            }
        }
        return res+len;
    }
}
// @lc code=end

