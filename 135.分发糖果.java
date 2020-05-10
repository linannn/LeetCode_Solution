/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        for (int i = len-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
                candy[i] = candy[i+1] + 1;
            }
        }
        int sum = 0;
        for (int i : candy) {
            sum += i;
        }
        return sum;
    }
}
// @lc code=end

