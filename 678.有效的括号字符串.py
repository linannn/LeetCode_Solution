#
# @lc app=leetcode.cn id=678 lang=python3
#
# [678] 有效的括号字符串
#

# @lc code=start


class Solution:
    def checkValidString(self, s: str) -> bool:
        left = []
        star = []
        for i in range(len(s)):
            if s[i] == '(':
                left.append(i)
                continue
            if s[i] == '*':
                star.append(i)
                continue
            if s[i] == ')':
                if left:
                    left.pop()
                    continue
                if star:
                    star.pop()
                    continue
                return False
        while left:
            if not star:
                return False
            if not left.pop() < star.pop():
                return False
        return True
# @lc code=end
