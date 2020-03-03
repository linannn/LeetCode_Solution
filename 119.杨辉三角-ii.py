#
# @lc app=leetcode.cn id=119 lang=python3
#
# [119] 杨辉三角 II
#

# @lc code=start

from typing import List


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        res = []
        for i in range(rowIndex+1):
            row = []
            for idx in range(i+1):
                if idx == 0 or idx == i:
                    row.append(1)
                else:
                    row.append(res[idx-1]+res[idx])
            res = (row)
        return res

# @lc code=end
