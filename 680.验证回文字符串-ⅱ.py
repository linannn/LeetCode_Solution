#
# @lc app=leetcode.cn id=680 lang=python3
#
# [680] 验证回文字符串 Ⅱ
#

# @lc code=start


class Solution:
    def validPalindrome(self, s: str) -> bool:
        start = 0
        end = len(s) - 1
        while start < end:
            if s[start] == s[end]:
                start += 1
                end -= 1
            else:
                print(start)
                return s[start + 1:end + 1] == s[end:start:-1] or\
                    s[start:end] == ''.join(reversed(s[start:end]))
        return True

# @lc code=end
