#
# @lc app=leetcode.cn id=414 lang=python3
#
# [414] 第三大的数
#

# @lc code=start


class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        first = -float('inf')
        second = -float('inf')
        third = -float('inf')
        for i in range(len(nums)):
            if nums[i] == third or nums[i] == first or \
                    nums[i] == second:
                continue
            if nums[i] > third:
                first = second
                second = third
                third = nums[i]
                continue
            if nums[i] > second:
                first = second
                second = nums[i]
                continue
            if nums[i] > first:
                first = nums[i]
        return third if first == -float('inf') else first

# @lc code=end
