/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len+1; j++) {
                if (dp[i] && dict.contains(s.substring(i, j)))
                    dp[j] = true;
            }
        }
        return dp[len];
    }
}
// @lc code=end

