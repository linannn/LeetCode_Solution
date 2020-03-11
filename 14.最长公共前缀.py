#
# @lc app=leetcode.cn id=14 lang=python3
#
# [14] 最长公共前缀
#

# @lc code=start

from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ''
        if len(strs) == 0:
            return res
        min_length = min([len(s) for s in strs])
        for i in range(min_length):
            cur = strs[0][i]
            for s in strs:
                if s[i] != cur:
                    return res
            res += cur
        return res
# @lc code=end
