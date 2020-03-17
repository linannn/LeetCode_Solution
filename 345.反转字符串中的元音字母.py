#
# @lc app=leetcode.cn id=345 lang=python3
#
# [345] 反转字符串中的元音字母
#

# @lc code=start


class Solution:
    def reverseVowels(self, s: str) -> str:
        s = list(s)
        start, end = 0, len(s) - 1
        yuan = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        while start < end:
            while start < end and s[start] not in yuan:
                start += 1
            while start < end and s[end] not in yuan:
                end -= 1
            s[start], s[end] = s[end], s[start]
            start += 1
            end -= 1
        return "".join(s)

# @lc code=end
