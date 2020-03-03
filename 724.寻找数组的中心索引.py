#
# @lc app=leetcode.cn id=724 lang=python3
#
# [724] 寻找数组的中心索引
#

# @lc code=start

from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        r_sum = sum(nums[1:])
        l_sum = 0
        for i in range(0, len(nums)):
            if r_sum == l_sum:
                return i
            if i < len(nums) - 1:
                r_sum -= nums[i+1]
            l_sum += nums[i]
        return -1


# @lc code=end
