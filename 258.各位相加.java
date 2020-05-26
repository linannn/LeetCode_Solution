/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        // num = Math.abs(num);
        // int res = 0;
        // while (num != 0) {
        //     res += num % 10;
        //     num /= 10;
        // }
        // return res < 10 ? res : addDigits(res);
        return (num - 1) % 9 + 1;
    }
}
// @lc code=end

