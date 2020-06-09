/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {
    private int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i+1] = dp[i] + nums[i];
        }
    }
    
    public void update(int i, int val) {
        int updateSum = dp[i] + val;
        int diff = dp[i+1] - updateSum;
        for (int j = i+1; j < dp.length; j++) {
            dp[j]-=diff;
        }

    }
    
    public int sumRange(int i, int j) {

        return dp[j+1] - dp[i];

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
// @lc code=end

