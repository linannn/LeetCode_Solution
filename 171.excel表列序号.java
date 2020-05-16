/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        if (s == null) 
            return res;
        int len = s.length();
        int pow = 1;
        for (int i = len -1; i >=0; i--) {
            res += (s.charAt(i) + 1 -'A') * pow;
            pow *= 26;
        }
        return res;
    }
}
// @lc code=end

