/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) 
            return false;
        if (num == 1)
            return true;
        if ((num & 1) == 0)
            return isUgly(num / 2);
        else if (num % 3 == 0)
            return isUgly(num / 3);
        else if (num % 5 == 0) 
            return isUgly(num / 5);
        return false;
    }
}
// @lc code=end

