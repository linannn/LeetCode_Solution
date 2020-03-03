#
# @lc app=leetcode.cn id=695 lang=python3
#
# [695] 岛屿的最大面积
#

# @lc code=start

from queue import Queue
from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        def bfs(i, j):
            num = 0
            q = Queue()
            q.put((i, j))
            flag[i][j] = True
            while q.qsize() > 0:
                i, j = q.get()
                num += 1
                move_action = [(1, 0), (-1, 0), (0, 1), (0, -1)]
                for action in move_action:
                    ac = (i+action[0], j+action[1])
                    if 0 <= ac[0] < row and 0 <= ac[1] < col \
                            and not flag[ac[0]][ac[1]] and grid[ac[0]][ac[1]] == 1:
                        q.put(ac)
                        flag[ac[0]][ac[1]] = True

            return num
        row = len(grid)
        col = len(grid[0])
        flag = [[False for _ in range(col)] for _ in range(row)]
        res = 0
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1 and not flag[i][j]:
                    res = max(res, bfs(i, j))
        return res


# @lc code=end
