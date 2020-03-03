#
# @lc app=leetcode.cn id=861 lang=python3
#
# [861] 翻转矩阵后的得分
#

# @lc code=start
from typing import List


class Solution:
    def matrixScore(self, A: List[List[int]]) -> int:
        def calc(nums):
            res = 0
            for i in nums:
                res = (res << 1) + i
            return res
        dict = {1: 0, 0: 1}
        for row in A:
            if row[0] == 0:
                for i in range(len(row)):
                    row[i] = dict[row[i]]
        for j in range(len(A[0])):
            nums_1 = 0
            for i in range(len(A)):
                if A[i][j] == 1:
                    nums_1 += 1
            if len(A) - nums_1 > nums_1:
                for i in range(len(A)):
                    A[i][j] = dict[A[i][j]]
        sum_ = 0
        for i in A:
            sum_ += calc(i)
        return sum_


# @lc code=end
