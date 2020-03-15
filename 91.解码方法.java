/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0"))
            return 0;
        int last = 1;
        int cur = 1;
        int tmp;
        for (int i = 1; i < s.length(); i++) {
            tmp = cur;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')
                    cur = last;
                else 
                    return 0;
            } else if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) >='1' && s.charAt(i) <='6') {
                cur = cur+last;
            }
            last = tmp;
        }
        return cur;
    }
}
// @lc code=end

