#
# @lc app=leetcode.cn id=58 lang=python3
#
# [58] 最后一个单词的长度
#

# @lc code=start


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        length = 0
        s = s.rstrip()
        for ch in s[::-1]:
            if ch == ' ':
                return length
            else:
                length += 1
        return length
# @lc code=end
