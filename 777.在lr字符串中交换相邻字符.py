#
# @lc app=leetcode.cn id=777 lang=python3
#
# [777] 在LR字符串中交换相邻字符
#

# @lc code=start


class Solution:
    def canTransform(self, start: str, end: str) -> bool:
        if start.replace('X', '') != end.replace('X', ''):
            return False
        l_end_index = (i for i, c in enumerate(end) if c == 'L')
        r_end_index = (i for i, c in enumerate(end) if c == 'R')
        for i, c in enumerate(start):
            if c == 'L' and i < next(l_end_index):
                return False
        for i, c in enumerate(start):
            if c == 'R' and i > next(r_end_index):
                return False
        return True


# @lc code=end
