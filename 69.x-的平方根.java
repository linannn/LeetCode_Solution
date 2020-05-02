/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // 二分
        // long left = 0;
        // long right = x/2+1;
        // while (left < right) {
        //     long mid = (left + right + 1) >>> 1;
        //     long square = mid * mid;
        //     if (square > x) {
        //         right = mid - 1;
        //     } else {
        //         left = mid;
        //     }
        // }
        // return (int)left;
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;

    }
        
}
// @lc code=end

