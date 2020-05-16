/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mast = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mast) != 0)
                count++;
            mast <<= 1;
        }
        return count;
    }
}
// @lc code=end

