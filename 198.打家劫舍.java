/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        int tmp = 0;
        for (int i : nums) {
            tmp = curMax;
            curMax = Math.max(preMax+i, curMax);
            preMax = tmp;
        }
        return curMax;
    }
}
// @lc code=end

