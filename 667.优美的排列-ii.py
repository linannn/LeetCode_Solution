#
# @lc app=leetcode.cn id=667 lang=python3
#
# [667] 优美的排列 II
#

# @lc code=start


class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        res = [i for i in range(1, n+1)]  # 刚开始有一个不同的差绝对值
        for i in range(1, k):  # 每翻转后面一次产生一个新的
            res[i:] = res[:i-1:-1]  # 翻转
        return res
# @lc code=end
