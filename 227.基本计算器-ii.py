#
# @lc app=leetcode.cn id=227 lang=python3
#
# [227] 基本计算器 II
#

# @lc code=start
from typing import List
from collections import deque


class Solution:
    def calculate(self, s: str) -> int:
        # 我的
        # s = s.replace(' ', '')
        # li = []
        # idx = 0
        # while idx < len(s):
        #     if s[idx].isdigit():
        #         tmp = idx
        #         while idx < len(s) - 1 and s[idx + 1].isdigit():
        #             idx += 1
        #         li.append(int(s[tmp:idx + 1]))
        #     else:
        #         li.append(s[idx])
        #     idx += 1
        # li_1 = []
        # idx = 0
        # while idx < len(li):
        #     if isinstance(li[idx], str):
        #         if li[idx] == '/':
        #             li_1.append(li_1.pop() // li[idx + 1])
        #             idx += 1
        #         elif li[idx] == '*':
        #             li_1.append(li_1.pop() * li[idx + 1])
        #             idx += 1
        #         else:
        #             li_1.append(li[idx])
        #     else:
        #         li_1.append(li[idx])
        #     idx += 1
        # idx = 0
        # li_2 = []
        # while idx < len(li_1):
        #     if isinstance(li_1[idx], str):
        #         if li_1[idx] == '+':
        #             li_2.append(li_2.pop() + li_1[idx + 1])
        #             idx += 1
        #         else:
        #             li_2.append(li_2.pop() - li_1[idx + 1])
        #             idx += 1
        #     else:
        #         li_2.append(li_1[idx])
        #     idx += 1
        # return li_2[0]
        def helper(li: deque) -> int:
            stack = []
            sign = '+'
            num = 0
            while li:
                ch = li.popleft()
                if ch.isdigit():
                    num = 10 * num + int(ch)
                if not ch.isdigit() and ch != ' ' or len(li) == 0:
                    if sign == '+':
                        stack.append(num)
                    elif sign == '-':
                        stack.append(-num)
                    elif sign == '*':
                        stack.append(stack.pop()*num)
                    elif sign == '/':
                        stack.append(int(stack.pop() / float(num)))
                    num = 0
                    sign = ch
            return sum(stack)
        return helper(deque(list(s)))
# @lc code=end
