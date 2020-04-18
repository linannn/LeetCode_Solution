#
# @lc app=leetcode.cn id=198 lang=python3
#
# [198] 打家劫舍
#

# @lc code=start
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        # 用数组
        # if not nums:
        #     return 0
        # if len(nums) <= 2:
        #     return max(nums)
        # dp = [0] * len(nums)
        # dp[0] = nums[0]
        # dp[1] = max(nums[:2])
        # for i in range(2, len(nums)):
        #     dp[i] = max(dp[i-1], nums[i]+dp[i-2])

        # return max(dp[-1], dp[-2])
        if not nums:
            return 0
        pre_max = 0
        cur_max = 0
        for i in nums:
            pre_max, cur_max = cur_max, max(pre_max+i, cur_max)
        return cur_max
# @lc code=end
