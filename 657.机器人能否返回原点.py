#
# @lc app=leetcode.cn id=657 lang=python3
#
# [657] 机器人能否返回原点
#

# @lc code=start
from collections import Counter


class Solution:
    def judgeCircle(self, moves: str) -> bool:
        # dict = Counter(moves)
        # if 'R' not in dict:
        #     dict['R'] = 0
        # if 'L' not in dict:
        #     dict['L'] = 0
        # if 'U' not in dict:
        #     dict['U'] = 0
        # if 'D' not in dict:
        #     dict['D'] = 0
        # return dict['R'] == dict['L'] and dict['U'] == dict['D']
        lr = 0
        ud = 0
        for ch in moves:
            if ch == 'R':
                lr += 1
            elif ch == 'L':
                lr -= 1
            elif ch == 'U':
                ud += 1
            else:
                ud -= 1
        return lr == 0 and ud == 0
# @lc code=end
