#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
from collections import defaultdict


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        dict = defaultdict(int)
        for ch in s:
            dict[ch] += 1
        for ch in t:
            dict[ch] -= 1
        return len(list(filter(lambda item: item[1] != 0, dict.items()))) == 0

# @lc code=end
