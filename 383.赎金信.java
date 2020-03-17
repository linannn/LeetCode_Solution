/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        short[] count = new short[26];
        // for (char ch : ransomNote.toCharArray())
        //     count[ch-'a']--;
        // for (char ch: magazine.toCharArray())
        //     count[ch-'a']++;
        // for (short s : count) {
        //     if (s<0)
        //         return false;
        // }
        // return true;
        int idx = 0;
        for (char ch: ransomNote.toCharArray()) {
            idx = magazine.indexOf(ch, count[ch-'a']);
            if (idx == -1)
                return false;
            count[ch-'a'] = (short)(idx + 1);
        }
        return true;
    }
}
// @lc code=end

