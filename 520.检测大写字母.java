/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        int num = 0;
        for (int i = 0; i< word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))){
                num++;
            }
        }
        return num == 0 || num == word.length() 
        || num == 1 && Character.isUpperCase(word.charAt(0));
    }
}
// @lc code=end

