#
# @lc app=leetcode.cn id=766 lang=python3
#
# [766] 托普利茨矩阵
#

# @lc code=start


class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        for i in range(row):
            tmp = set()
            tmp.add(matrix[i][0])
            for j in range(1, min(row-i, col)):
                if matrix[i + j][j] not in tmp:
                    return False

        for i in range(1, col):
            tmp = set()
            tmp.add(matrix[0][i])
            for j in range(1, min(row, col-i)):
                if matrix[j][j+i] not in tmp:
                    return False
        return True
# @lc code=end
