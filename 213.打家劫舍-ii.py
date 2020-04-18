#
# @lc app=leetcode.cn id=213 lang=python3
#
# [213] 打家劫舍 II
#

# @lc code=start
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        cur_max = 0
        pre_max = 0
        for i in nums[:-1]:
            cur_max, pre_max = max(pre_max + i, cur_max), cur_max
        m1 = cur_max
        cur_max = 0
        pre_max = 0
        for i in nums[1:]:
            cur_max, pre_max = max(pre_max + i, cur_max), cur_max
        return max(m1, cur_max)
# @lc code=end
