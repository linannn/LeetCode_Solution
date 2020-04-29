/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int len = matrix.length - 1;
        int circle = matrix.length / 2;
        for (int i = 0; i < circle; i++) {
            for (int j = 0; j < matrix.length - 2*i - 1; j++) {
                int tmp = matrix[i + j][len - i];
                matrix[i + j][len - i] = matrix[i][i + j];
                matrix[i][i + j] = matrix[len - i - j][i];
                matrix[len - i - j][i] = matrix[len - i][len - i - j];
                matrix[len - i][len - i - j] = tmp;
            }
        }
    }
}
// @lc code=end

