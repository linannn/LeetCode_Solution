/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int length = nums.length;
        int curIdx = 0;
        int step = 1;
        int maxInterval = nums[0];
        while (curIdx + maxInterval < length-1) {
            int longer = 0;
            int longerId = curIdx + maxInterval;
            for (int i = 1; i <= maxInterval; i++) {
                if (longer < i - maxInterval + nums[i + curIdx]) {
                    longer = i - maxInterval + nums[i + curIdx];
                    longerId = curIdx + i;
                }
            }
            curIdx = longerId;
            if (curIdx >= nums.length - 1) {
                break;
            }
            step++;
            maxInterval = nums[curIdx];
        }

        return step;
    }
}
// @lc code=end

