#
# @lc app=leetcode.cn id=150 lang=python3
#
# [150] 逆波兰表达式求值
#

# @lc code=start
from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operater = {'+', '-', '*', '/'}
        stack = []
        for ch in tokens:
            if ch not in operater:
                stack.append(int(ch))
            else:
                num2 = stack.pop()
                num1 = stack.pop()
                if ch == '+':
                    stack.append(num1+num2)
                elif ch == '-':
                    stack.append(num1 - num2)
                elif ch == '*':
                    stack.append(num1*num2)
                else:
                    stack.append(int(num1/num2))
        return 0 if not stack else int(stack[0])

# @lc code=end
