#
# @lc app=leetcode.cn id=566 lang=python3
#
# [566] 重塑矩阵
#

# @lc code=start


class Solution:
    def matrixReshape(self, nums: List[List[int]], r: int, c: int) -> List[List[int]]:
        row = len(nums)
        col = len(nums[0])
        if row * col != r * c:
            return nums
        res = []
        for i in range(r):
            tmp = []
            for j in range(c):
                _len = i*c+j
                tmp.append(nums[_len // col][_len % col])
            res.append(tmp)
        return res

# @lc code=end
