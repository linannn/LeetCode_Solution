#
# @lc app=leetcode.cn id=647 lang=python3
#
# [647] 回文子串
#

# @lc code=start


class Solution:
    def countSubstrings(self, s: str) -> int:
        s_len = len(s)
        dp = [[False for i in s] for i in range(s_len+1)]
        for i in range(s_len):
            dp[0][i] = True
            dp[1][i] = True
        res = 0
        for i in range(2, s_len+1):
            for j in range(s_len - i + 1):
                dp[i][j] = s[j] == s[j + i - 1] and dp[i - 2][j + 1]
                if dp[i][j]:
                    res += 1
        return res+s_len
# @lc code=end
