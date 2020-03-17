/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        String[] strs = s.split(" ");
        int res = 0;
        for (String str: strs) {
            if (str.length() == 0)
                continue;
            res++;
        }
        return res;
    }
}
// @lc code=end

