#
# @lc app=leetcode.cn id=581 lang=python3
#
# [581] 最短无序连续子数组
#

# @lc code=start


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        tmp = nums + []
        tmp.sort()
        start = 0
        for i in range(len(nums)):
            if nums[i] != tmp[i]:
                start = i
                break
        end = -1
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] != tmp[i]:
                end = i
                break
        return end-start + 1

# @lc code=end
