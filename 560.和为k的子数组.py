#
# @lc app=leetcode.cn id=560 lang=python3
#
# [560] 和为K的子数组
#

# @lc code=start


from collections import defaultdict
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        _sum = 0
        _map = defaultdict(int)
        _map[0] = 1
        for i in nums:
            _sum += i
            if _sum-k in _map:
                count += _map[_sum-k]
            _map[_sum] += 1
        return count
# @lc code=end
