#
# @lc app=leetcode.cn id=905 lang=python3
#
# [905] 按奇偶排序数组
#

# @lc code=start
from typing import List


class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        start = 0
        end = len(A) - 1
        while start < end:
            if A[start] % 2 == 1:
                A[start], A[end] = A[end], A[start]
                end -= 1
            else:
                start += 1
        return A

# @lc code=end
