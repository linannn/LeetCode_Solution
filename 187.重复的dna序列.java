/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
import java.util.HashSet;
import java.util.ArrayList;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < s.length()-10+1; i++) {
            if (seen.contains(s.substring(i, i+10)))
                res.add(s.substring(i, i+10));
            else
                seen.add(s.substring(i, i+10));
        }
        return new ArrayList<>(res);
    }
}
// @lc code=end

