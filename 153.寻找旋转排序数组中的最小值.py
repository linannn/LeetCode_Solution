#
# @lc app=leetcode.cn id=153 lang=python3
#
# [153] 寻找旋转排序数组中的最小值
#

# @lc code=start


class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        if len(nums) == 1:
            return nums[0]
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            if nums[mid] > nums[right]:
                left = mid
            else:
                right = mid
        return nums[0]
        # _min = nums[0]
        # for i in range(len(nums)):
        #     if nums[i] < _min:
        #         return nums[i]
        # return _min

# @lc code=end
