/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (t == null || s == null || t.equals("") || s.equals("") || s.length() < t.length()){
            return "";
        }
        Map<Character, Integer> oriMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = oriMap.getOrDefault(t.charAt(i), 0);
            oriMap.put(t.charAt(i), --count);
        }
        int start = 0;
        int end = 0;
        String res = "";
        Map<Character, Integer> map = new HashMap<>(oriMap);
        while (end < s.length()) {
            while (end < s.length() && !check(map)) {
                if (map.containsKey(s.charAt(end))) {
                    int count = map.getOrDefault(s.charAt(end), 0);
                    count++;
                    map.put(s.charAt(end), count);
                }
                end++;
            }
            while (start < end && check(map)) {
                char tmp = s.charAt(start);
                if (map.containsKey(tmp)) {
                    int count = map.get(tmp);
                    if (count == 0) {
                        String n = s.substring(start, end);
                        if (res.length() == 0)
                            res = n;
                        else
                            res = res.length() < n.length() ? res : n;
                        start++;
                        count--;
                        map.put(tmp, count);
                        break;
                    }
                    count--;
                    map.put(tmp, count);
                }
                start++;
            }
        }

        return res;
    }

    private boolean check(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

