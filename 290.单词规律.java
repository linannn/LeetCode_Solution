/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
import java.util.HashMap;
import java.util.HashSet;
class Solution {
    private HashMap<Character, String> map = new HashMap<>();
    private HashSet<String> set = new HashSet<>();
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null)
            return false;
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (set.contains(arr[i]))
                    return false;
                set.add(arr[i]);
                map.put(pattern.charAt(i), arr[i]);
                continue;
            }
            if (!map.get(pattern.charAt(i)).equals(arr[i]))
                return false;
        }
        return true;
    }
}
// @lc code=end

