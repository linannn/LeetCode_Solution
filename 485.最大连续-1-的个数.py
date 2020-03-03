#
# @lc app=leetcode.cn id=485 lang=python3
#
# [485] 最大连续1的个数
#

# @lc code=start


class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        res = 0
        z_num = 0
        for i in nums:
            if i == 0:
                res = max(res, z_num)
                z_num = 0
            if i == 1:
                z_num += 1
        res = max(res, z_num)
        return res

# @lc code=end
