#
# @lc app=leetcode.cn id=118 lang=python3
#
# [118] 杨辉三角
#

# @lc code=start


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        if numRows == 0:
            return []
        for i in range(numRows):
            row = []
            for idx in range(i+1):
                if idx == 0 or idx == i:
                    row.append(1)
                else:
                    row.append(res[i-1][idx-1]+res[i-1][idx])
            res.append(row)
        return res

# @lc code=end
