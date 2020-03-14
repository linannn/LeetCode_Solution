#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#

# @lc code=start
from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # 我的
        # def gene(stack, s, depth):
        #     stack = stack+[]
        #     if depth == 0:
        #         res.append(s + ')' * len(stack))
        #         return

        #     if not stack:
        #         stack.append("(")
        #         gene(stack, s+'(', depth - 1)
        #         stack.pop()
        #     else:
        #         stack.append('(')
        #         gene(stack, s + '(', depth-1)
        #         stack.pop()
        #         if stack:
        #             stack.pop()
        #             gene(stack, s+')', depth)

        # res = []
        # gene([], '', n)
        # return res
        def gene(s='', left=0, right=0):
            if len(s) == 2 * n:
                res.append(s)
                return
            if left < n:
                gene(s+'(', left+1, right)
            if right < left:
                gene(s+')', left, right+1)
        res = []
        gene()
        return res
# @lc code=end
