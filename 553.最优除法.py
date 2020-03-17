#
# @lc app=leetcode.cn id=553 lang=python3
#
# [553] 最优除法
#

# @lc code=start
from typing import List


class Solution:
    def optimalDivision(self, nums: List[int]) -> str:
        if not nums:
            return ""
        nums = [str(i) for i in nums]
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return nums[0] + "/" + nums[1]
        s = '/'.join(nums)+')'
        idx = s.find('/')
        s = s[:idx+1] + '('+s[idx+1:]
        return s
# @lc code=end
