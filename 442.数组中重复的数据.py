#
# @lc app=leetcode.cn id=442 lang=python3
#
# [442] 数组中重复的数据
#

# @lc code=start


class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []
        for num in nums:
            if nums[abs(num)-1] > 0:
                nums[abs(num)-1] *= -1
            else:
                res.append(abs(num))
        return res

# @lc code=end
