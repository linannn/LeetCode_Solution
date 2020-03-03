#
# @lc app=leetcode.cn id=898 lang=python3
#
# [898] 子数组按位或操作
#

# @lc code=start
from typing import List


class Solution:
    def subarrayBitwiseORs(self, A: List[int]) -> int:
        cur, res = set(), set()
        for a in A:
            cur = {a | b for b in cur}
            cur.add(a)
            res |= cur
        return len(res)

# @lc code=end
