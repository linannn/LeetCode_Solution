/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length==0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row+1][col+1];
        if (col == 0)
            return;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                sum[i+1][j+1] = sum[i][j+1]+sum[i+1][j]+matrix[i][j]-sum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1]+sum[row1][col1]
        -sum[row1][col2+1]-sum[row2+1][col1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

