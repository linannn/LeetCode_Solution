#
# @lc app=leetcode.cn id=274 lang=python3
#
# [274] H 指数
#

# @lc code=start
from typing import List


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort(reverse=True)
        res = 0
        for idx, c in enumerate(citations):
            if idx >= c:
                break
            res += 1
        return res
# @lc code=end
