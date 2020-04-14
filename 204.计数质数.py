#
# @lc app=leetcode.cn id=204 lang=python3
#
# [204] 计数质数
#

# @lc code=start


class Solution:
    def countPrimes(self, n: int) -> int:
        flags = [True] * n
        for i in range(2, n):
            if flags[i]:
                for j in range(2 * i, n, i):
                    flags[j] = False
        return max(len(list(filter(lambda t: t, flags)))-2, 0)
# @lc code=end
