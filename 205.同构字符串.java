/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        if (s == null)
            return true;
        for (int i = 0; i < s.length(); i++){
            char chS = s.charAt(i);
            if (map.containsKey(chS)) {
                if (t.charAt(i) != map.get(chS)) {
                    return false;

                }
            } else {
                map.put(chS, t.charAt(i));
                if (set.contains(t.charAt(i))) {
                    return false;
                }
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}
// @lc code=end

