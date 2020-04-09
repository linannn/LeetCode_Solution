#
# @lc app=leetcode.cn id=136 lang=python3
#
# [136] 只出现一次的数字
#

# @lc code=start
from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # return 2*sum(set(nums)) - sum(nums)
        res = 0
        for i in nums:
            res ^= i
        return res
# @lc code=end
