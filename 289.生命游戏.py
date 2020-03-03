#
# @lc app=leetcode.cn id=289 lang=python3
#
# [289] 生命游戏
#

# @lc code=start


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])
        flag = [[True for _ in range(col)] for _ in range(row)]

        def death(x, y):
            num = 0
            for i in range(max(0, x - 1), min(row, x+2)):
                for j in range(max(0, y - 1), min(col, y + 2)):
                    if board[i][j] == 1 and not (i == x and j == y):
                        num += 1
            if num < 2:
                return 0
            if num == 2 and board[x][y] == 1:
                return 1
            if num == 3:
                return 1
            return 0
        for i in range(row):
            for j in range(col):
                flag[i][j] = board[i][j] == death(i, j)
        for i in range(row):
            for j in range(col):
                if not flag[i][j]:
                    if board[i][j] == 0:
                        board[i][j] = 1
                    else:
                        board[i][j] = 0


# @lc code=end
