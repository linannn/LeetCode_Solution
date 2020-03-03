#
# @lc app=leetcode.cn id=932 lang=python3
#
# [932] 漂亮数组
#

# @lc code=start
from typing import List


class Solution:
    def beautifulArray(self, N: int) -> List[int]:
        if N == 1:
            return [1]
        if N == 2:
            return [1, 2]
        if N == 3:
            return [1, 3, 2]
        if N == 4:
            return [1, 3, 2, 4]
        tmp = [1, 3, 2, 4]
        while len(tmp) < N:
            for i in range(len(tmp)):
                tmp[i] = tmp[i] * 2 - 1
            tmp.extend([i+1 for i in tmp])
        return list(filter(lambda i: i <= N, tmp))

# @lc code=end
