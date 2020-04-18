/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(hepler(Arrays.copyOfRange(nums, 0, nums.length-1)),
        hepler(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int hepler(int[] nums) {
        int curMax = 0;
        int preMax = 0;
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

