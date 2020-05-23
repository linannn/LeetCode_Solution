/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    // public int countDigitOne(int n) {
    //     int res = 0;
    //     long power = 10;
    //     long unit = 1;
    //     while (unit <= n) {
    //         long nums = n / power;
    //         res += nums * unit;
    //         if (unit == 1) {
    //             res += n >= power * nums + 1 ? 1 : 0;
    //         } else {
    //             res += n >= power * nums + 2*unit ? unit : Math.max(n - power * nums - unit + 1, 0);
    //         }
    //         power *= 10;
    //         unit *= 10;
    //     }
    //     return res;
    // }
    public int countDigitOne(int n) {
        int res = 0;
        long power = 10;
        long unit = 1;
        while (unit <= n) {
            res += n / power * unit;
            res += Math.min(Math.max(n % power - unit + 1, 0), unit);
            power *= 10;
            unit *= 10;
        }
        return res;
    }

}
// @lc code=end

