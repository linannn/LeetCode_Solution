#
# @lc app=leetcode.cn id=665 lang=python3
#
# [665] 非递减数列
#

# @lc code=start


class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        reduce_num = 0

        for i in range(len(nums)-1):
            if nums[i] > nums[i+1]:
                reduce_num += 1
                if reduce_num > 1:
                    break
                if i > 0 and nums[i-1] > nums[i+1]:
                    nums[i+1] = nums[i]
                else:
                    nums[i] = nums[i+1]
        return reduce_num <= 1
# @lc code=end
