#
# @lc app=leetcode.cn id=268 lang=python3
#
# [268] 缺失数字
#

# @lc code=start


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        _sum = 0
        index_sum = 0
        for i, num in enumerate(nums):
            _sum += num
            index_sum += i
        return len(nums) + index_sum - _sum

# 0123 0234 4-3
# 0123 0124 4-2
# @lc code=end
