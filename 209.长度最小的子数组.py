#
# @lc app=leetcode.cn id=209 lang=python3
#
# [209] 长度最小的子数组
#

# @lc code=start


class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        start = 0
        _sum = 0
        min_len = float('inf')
        for i in range(len(nums)):
            _sum += nums[i]
            while _sum >= s:
                min_len = min(min_len, i - start+1)
                _sum -= nums[start]
                start += 1
        return 0 if min_len == float('inf') else min_len


# @lc code=end
