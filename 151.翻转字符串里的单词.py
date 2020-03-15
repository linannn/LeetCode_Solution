#
# @lc app=leetcode.cn id=151 lang=python3
#
# [151] 翻转字符串里的单词
#

# @lc code=start


class Solution:
    def reverseWords(self, s: str) -> str:
        strs = list(filter(lambda item: item != '', s.split(' ')))
        strs.reverse()
        return ' '.join(strs)
# @lc code=end
