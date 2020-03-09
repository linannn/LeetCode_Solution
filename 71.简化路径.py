#
# @lc app=leetcode.cn id=71 lang=python3
#
# [71] 简化路径
#

# @lc code=start


class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        path_part = path.split('/')
        for part in path_part:
            if part == '' or part == '.':
                continue
            if part == '..':
                if len(stack) > 0:
                    stack.pop()
            else:
                stack.append(part)
        return '/'+'/'.join(stack)
# @lc code=end
