/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n -= 1;
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
// @lc code=end

