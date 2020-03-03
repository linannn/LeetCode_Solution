#
# @lc app=leetcode.cn id=941 lang=python3
#
# [941] 有效的山脉数组
#

# @lc code=start
from typing import List


class Solution:
    def validMountainArray(self, A: List[int]) -> bool:
        if len(A) < 3:
            return False
        l_idx = 0
        r_idx = len(A) - 1
        while l_idx < len(A) - 1 and A[l_idx] < A[l_idx + 1]:
            l_idx += 1
        while r_idx > 1 and A[r_idx] < A[r_idx - 1]:
            r_idx -= 1
        return l_idx == r_idx and l_idx != 0 and r_idx != len(A)-1

# @lc code=end
