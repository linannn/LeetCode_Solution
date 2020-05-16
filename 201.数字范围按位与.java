/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */
// 000 001 010 011 100 101 110
// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }
}
// @lc code=end

