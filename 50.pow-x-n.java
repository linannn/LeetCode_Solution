/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long newN = n;
        if (x == 1 || n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            newN = -newN;
        }
        return helper(x, newN);
    }
    private double helper(double x, long newN) {
        if (newN == 0) {
            return 1;
        }
        double half = helper(x, newN / 2);
        if (newN % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
// @lc code=end

