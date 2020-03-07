#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
#

# @lc code=start


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        dict = {'(': ')', '{': '}', '[': ']'}
        for s_ele in s:
            if s_ele in dict:
                stack.append(s_ele)
            else:
                if len(stack) == 0:
                    return False
                if dict[stack.pop()] != s_ele:
                    return False
        return len(stack) == 0
# @lc code=end
