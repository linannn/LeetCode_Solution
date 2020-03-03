#
# @lc app=leetcode.cn id=870 lang=python3
#
# [870] 优势洗牌
#

# @lc code=start

from typing import List
from collections import defaultdict


class Solution:
    def advantageCount(self, A: List[int], B: List[int]) -> List[int]:
        li = [(i, idx) for idx, i in enumerate(B)]
        A.sort()
        li.sort(key=lambda l: l[0])
        res = [-1 for _ in range(len(A))]
        min_pos = 0
        max_pos = len(A) - 1
        for a in A:
            if a > li[min_pos][0]:
                res[li[min_pos][1]] = a
                min_pos += 1
            else:
                res[li[max_pos][1]] = a
                max_pos -= 1
        return res


# @lc code=end
