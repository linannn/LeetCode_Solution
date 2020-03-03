#
# @lc app=leetcode.cn id=697 lang=python3
#
# [697] 数组的度
#

# @lc code=start
from collections import defaultdict


class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        dict = defaultdict(int)
        for i in nums:
            dict[i] += i
        sort_tu = sorted(dict.items(), key=lambda x: x[1])
        max_num = set()
        max_num.add(sort_tu[-1][0])
        idx = len(sort_tu)-1
        while idx > 1 and sort_tu[idx][0] == sort_tu[idx-1][0]:
            max_num.add(sort_tu[idx - 1][0])
            idx -= 1
        start = 0
        for i in range(len(nums)):
            if nums[i] in max_num:
                start = i
                break
        end = len(nums)-1
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] in max_num:
                end = i
                break

        return end-start+1

# @lc code=end
