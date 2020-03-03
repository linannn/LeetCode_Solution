#
# @lc app=leetcode.cn id=120 lang=python3
#
# [120] 三角形最小路径和
#

# @lc code=start


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = triangle + []  # 这边的初始化真的是牛逼，不仅不需要把把上面两行特殊的情况考虑进去，而且为下面也做了铺垫。
        m = len(dp)

        for i in range(1, m):
            for j in range(i+1):
                if j == 0:
                    dp[i][j] += dp[i-1][j]  # 承接上面，妙啊！
                if j > 0 and j == i:
                    dp[i][j] += dp[i-1][j-1]

                elif (j > 0 and j < i):
                    dp[i][j] += min(dp[i-1][j-1], dp[i-1][j])
        return (min(dp[-1]))

# @lc code=end
