/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    //         return false;
    //     int row = matrix.length;
    //     int col = matrix[0].length;
    //     int i = 0;
    //     int j = col-1;
    //     while (i < row && j >= 0) {
    //         if (target > matrix[i][j]) {
    //             i++;
    //         } else if (target < matrix[i][j]) {
    //             j--;
    //         } else {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
           return false;
        for (int[] nums: matrix) {
            if (biSearch(nums, target))
                return true;
        }
        return false;
    }
    private boolean biSearch(int[] nums, int target) {
        int len = nums.length;
        if (nums[0] > target || nums[len-1] < target) 
            return false;
        int left = 0;
        int right = len-1;
        int mid;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
// @lc code=end

