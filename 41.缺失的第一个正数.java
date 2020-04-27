/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int length = nums.length;
        boolean containOne = false;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1)
                containOne = true;
            if (nums[i] <= 0 || nums[i] > length)
                nums[i] = 1;
        }
        if (!containOne)
            return 1;
        int idx = 0;
        for (int i = 0; i < length; i++) {
            idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0)
                nums[idx] = - nums[idx];
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return length + 1;
    }
}
// @lc code=end

