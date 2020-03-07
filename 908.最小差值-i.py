#
# @lc app=leetcode.cn id=908 lang=python3
#
# [908] 最小差值 I
#

# @lc code=start


class Solution:
    def smallestRangeI(self, A: List[int], K: int) -> int:
        _max = A[0]
        _min = A[0]
        for i in A:
            _max = max(_max, i)
            _min = min(_min, i)
        tmp = _max - _min - K - K
        return 0 if tmp <= 0 else tmp

# @lc code=end
