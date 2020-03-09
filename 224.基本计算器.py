#
# @lc app=leetcode.cn id=224 lang=python3
#
# [224] 基本计算器
#

# @lc code=start


class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        stack = []
        for ch in s:
            if ch == ')':
                tmp = []
                while stack[-1] != '(':
                    tmp.append(stack.pop())
                if stack[-1] == '(':
                    stack.pop()
                res = tmp.pop()
                while tmp:
                    op = tmp.pop()
                    if op == '-':
                        res -= tmp.pop()
                    else:
                        res += tmp.pop()
                stack.append(res)
            elif ch == '(' or ch == '+' or ch == '-':
                stack.append(ch)
            elif ch == ' ':
                continue
            else:
                stack.append(int(ch))
        if len(stack) > 1:
            tmp = []
            while stack:
                tmp.append(stack.pop())
            res = tmp.pop()
            while tmp:
                op = tmp.pop()
                if op == '-':
                    res -= tmp.pop()
                else:
                    res += tmp.pop()
            stack.append(res)
        return stack[0]

# @lc code=end
