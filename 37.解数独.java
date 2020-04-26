/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    char[][] board;
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] box = new boolean[9][9];
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int k = (i/3)*3 + j/3;
                    row[i][num] = col[j][num] = box[k][num] = true;
                }
            }
        }
        this.board = board;
        helper(0);
    }
    private boolean helper(int n) {
        if (n == 81) 
            return true;
        int i = n / 9;
        int j = n % 9;
        if (board[i][j] != '.')
            return helper(n+1);
        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num])
                continue;
            board[i][j] = (char) (num + '1');
            row[i][num] = col[j][num] = box[k][num] = true;
            if (helper(n+1))
                return true;
            row[i][num] = col[j][num] = box[k][num] = false;
        }
        board[i][j] = '.';
        return false;
    }
}
// @lc code=end

