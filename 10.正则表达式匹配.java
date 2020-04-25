/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    short [][] dp;
    public boolean isMatch(String s, String p) {
        dp = new short[s.length()+1][p.length()+1];
        return helper(0, 0, s, p);
    }
    private boolean helper(int i, int j, String s, String p) {
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        boolean res;
        if (j == p.length()) {
            res = i == s.length();
        } else {
            boolean firstMatch = i < s.length() && 
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j + 1 < p.length() && p.charAt(j+1) == '*') {
                res = (firstMatch && helper(i+1, j, s, p))||
                helper(i, j+2, s, p);
            }
            else {
                res = firstMatch && helper(i+1, j+1, s, p);
            }
        }
        dp[i][j] = (short) (res ? 1 : -1);

        return res;
    }
}
// @lc code=end

