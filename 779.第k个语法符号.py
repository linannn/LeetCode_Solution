#
# @lc app=leetcode.cn id=779 lang=python3
#
# [779] 第K个语法符号
#

# @lc code=start


class Solution:
    def kthGrammar(self, N: int, K: int) -> int:
        ope = []
        idx = K-1
        for i in range(N):
            ope.append((idx//2, idx % 2))
            idx = idx // 2
        _map = {0: [0, 1], 1: [1, 0]}
        res = 0
        for i, j in ope[::-1]:
            res = _map[res][j]
        return res
# @lc code=end
