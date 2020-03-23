/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] li = s.split(" ");
        for (int i = 0; i < li.length; i++) {
            StringBuilder b = new StringBuilder(li[i]);
            li[i] = b.reverse().toString();
        }
        StringBuilder sb = new StringBuilder(li[0]);
        for (int i = 1; i < li.length; i ++) {
            sb.append(" ");
            sb.append(li[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

