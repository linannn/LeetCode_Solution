#
# @lc app=leetcode.cn id=539 lang=python3
#
# [539] 最小时间差
#

# @lc code=start
from typing import List


class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        li = set()
        for time in timePoints:
            k = int(time[:2]) * 60 + int(time[3:])
            if k in li:
                return 0
            li.add(k)
        li = sorted(li)
        m = float('inf')
        ONE_DAY_MIN = 60*24
        for i in range(1, len(li)):
            m = min(m, li[i] - li[i - 1])
        m = min(m, li[0] + ONE_DAY_MIN - li[-1])
        return m

# @lc code=end
