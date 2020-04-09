#
# @lc app=leetcode.cn id=36 lang=python3
#
# [36] 有效的数独
#

# @lc code=start
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        col_set = [set() for i in range(9)]
        row_set = [set() for i in range(9)]
        unit_set = [set() for i in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                if board[i][j] in col_set[j] or \
                    board[i][j] in row_set[i] or \
                        board[i][j] in unit_set[i // 3 * 3 + j // 3]:
                    return False
                else:
                    col_set[j].add(board[i][j])
                    row_set[i].add(board[i][j])
                    unit_set[i // 3 * 3 + j // 3].add(board[i][j])
        return True
# @lc code=end
