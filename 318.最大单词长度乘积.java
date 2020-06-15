/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) 
            return 0;
        int len = words.length;
        int[] bits = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bits[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
// @lc code=end

