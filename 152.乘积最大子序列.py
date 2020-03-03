#
# @lc app=leetcode.cn id=152 lang=python3
#
# [152] 乘积最大子序列
#

# @lc code=start


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        _max = -float('inf')
        tmp_max = 1
        tmp_min = 1
        for i in range(len(nums)):
            if nums[i] < 0:
                tmp_max, tmp_min = tmp_min, tmp_max
            tmp_max = max(tmp_max*nums[i], nums[i])
            tmp_min = min(tmp_min*nums[i], nums[i])
            _max = max(_max, tmp_max)
        return _max

# @lc code=end
