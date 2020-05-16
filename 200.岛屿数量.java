/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    private final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        char[][] gridNew = new char[row+2][col+2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gridNew[i+1][j+1] = grid[i][j];
            }
        }
        int count = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (gridNew[i][j] == '1') {
                    count++;
                    helper(gridNew, i, j);
                }
            }
        }
        return count;

    }
    private void helper(char[][] grid, int i, int j) {
        if (grid[i][j] == '1'){
            grid[i][j] = 'A';
            for(int[] dir: direction) {
                helper(grid, i+dir[0], j+dir[1]);
            }
        }
    }
    
}
// @lc code=end

