#
# @lc app=leetcode.cn id=6 lang=python3
#
# [6] Z 字形变换
#

# @lc code=start
import math


class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # 我的
        # def fill(i):
        #     s_start_idx = i * n_size
        #     last = length - s_start_idx
        #     col_start = i*(numRows-1)
        #     for i in range(min(last, numRows)):
        #         matrix[i][col_start] = s[s_start_idx + i]
        #     for i in range(min(last-numRows, numRows-2)):
        #         matrix[numRows-2-i][col_start+i+1] = s[s_start_idx+i+numRows]

        # length = len(s)
        # if length <= numRows or numRows == 1:
        #     return s
        # n_size = 2 * numRows - 2
        # col = math.ceil(length / n_size) * (numRows-1)
        # matrix = [['' for _ in range(col)] for _ in range(numRows)]
        # for i in range(math.ceil(length / n_size)):
        #     fill(i)
        # return ''.join([''.join(i) for i in matrix])

        if numRows == 1:
            return s
        length = len(s)
        res_array = [[] for i in range(min(numRows, length))]
        row = 0
        direction = False
        for ch in s:
            res_array[row].append(ch)
            if row == 0 or row == numRows - 1:
                direction = not direction
            row += 1 if direction else - 1

        return ''.join([''.join(i) for i in res_array])

# @lc code=end
