#
# @lc app=leetcode.cn id=747 lang=python3
#
# [747] 至少是其他数字两倍的最大数
#

# @lc code=start

from typing import List


class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        _max_idx = 0
        sec = -float('inf')
        for i in range(1, len(nums)):
            if nums[i] > nums[_max_idx]:
                sec = nums[_max_idx]
                _max_idx = i
            elif nums[i] > sec:
                sec = nums[i]
        return -1 if nums[_max_idx] < 2*sec else _max_idx

# @lc code=end
