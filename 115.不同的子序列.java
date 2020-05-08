/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    private int res = 0;
    public int numDistinct(String s, String t) {
        // // 回溯 超时
        // if (s.length() < t.length() || s.length() == 0)
        //     return res;
        // if (s.equals(t) || t.length()==0){
        //     res += 1;
        //     return res;
        // }
        // if (s.charAt(0) == t.charAt(0)) {
        //     numDistinct(s.substring(1), t.substring(1));
        // }
        // numDistinct(s.substring(1), t);
        // return res;
        // dp
        int ls = s.length();
        int lt = t.length();
        int[][] dp = new int[ls+1][lt+1];
        for (int i = 0; i < ls; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= ls; i++) {
            for (int j = 1; j <= lt; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[ls][lt];
    }

}
// @lc code=end

