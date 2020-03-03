#
# @lc app=leetcode.cn id=238 lang=python3
#
# [238] 除自身以外数组的乘积
#

# @lc code=start


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = nums + []
        k = 1
        length = len(nums)
        for i in range(length):
            res[i] = k
            k *= nums[i]
        k = 1
        for i in range(length):
            res[length - i - 1] *= k
            k *= nums[length - i - 1]
        return res


# @lc code=end
