#
# @lc app=leetcode.cn id=686 lang=python3
#
# [686] 重复叠加字符串匹配
#

# @lc code=start
import math


class Solution:
    def repeatedStringMatch(self, A: str, B: str) -> int:
        nums = math.ceil(len(B) / len(A))
        tmp = A * nums
        if tmp.find(B) != -1:
            return nums
        tmp += A
        return -1 if tmp.find(B) == -1 else nums + 1

# @lc code=end
