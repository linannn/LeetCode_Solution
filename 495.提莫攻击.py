#
# @lc app=leetcode.cn id=495 lang=python3
#
# [495] 提莫攻击
#

# @lc code=start


class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        last = -1
        res = 0
        for i in timeSeries:
            if last < i:
                last = i
            if i+duration > last:
                res += i+duration - last
                last = i + duration
        return res

# @lc code=end
