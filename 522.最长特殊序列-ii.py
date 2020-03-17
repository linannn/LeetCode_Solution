#
# @lc app=leetcode.cn id=522 lang=python3
#
# [522] 最长特殊序列 II
#

# @lc code=start
from collections import Counter
from typing import List


class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        def subString(s1, s2):
            i, j = 0, 0
            while i < len(s2) and j < len(s1):
                if s1[j] == s2[i]:
                    j += 1
                i += 1
            return j == len(s1)
        res = -1
        for i in range(len(strs)):
            for j in range(len(strs)):
                if j == i:
                    continue
                if subString(strs[i], strs[j]):
                    break
            if j == len(strs) - 1:
                res = max(res, len(strs[i]))
        return res
# @lc code=end
