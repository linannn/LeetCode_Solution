#
# @lc app=leetcode.cn id=852 lang=python3
#
# [852] 山脉数组的峰顶索引
#

# @lc code=start
from typing import List


class Solution:
    def peakIndexInMountainArray(self, A: List[int]) -> int:
        length = len(A) - 1
        start = 0
        end = length
        while start <= end:
            mid = (start + end) // 2
            if A[mid - 1] < A[mid] < A[mid + 1]:
                start = mid + 1
            elif A[mid - 1] > A[mid] > A[mid + 1]:
                end = mid - 1
            else:
                return mid
        return -1


# @lc code=end
