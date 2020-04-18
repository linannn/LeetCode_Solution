#
# @lc app=leetcode.cn id=221 lang=python3
#
# [221] 最大正方形
#

# @lc code=start
from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        dp = [[0] * (len(matrix[0])+1) for i in range(len(matrix)+1)]
        max_len = 0
        for i in range(1, len(matrix)+1):
            for j in range(1, len(matrix[0]) + 1):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1]
                                   [j - 1], dp[i - 1][j]) + 1
                    max_len = max(max_len, dp[i][j])
        return max_len**2
# @lc code=end
