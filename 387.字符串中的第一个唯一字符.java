/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
import java.util.LinkedHashMap;
class Solution {
    public int firstUniqChar(String s) {
        // 我的
        // if (s.length() == 0)
        //     return -1;
        // int[] idx = new int[26];
        // int j = 0;
        // for (int i = 0; i < 26; i++)
        //     idx[i] = -1;
        // for (int i = 0; i < s.length(); i++) {
        //     j = s.charAt(i)-97;
        //     if (idx[j] == -1)
        //         idx[j] = i;
        //     else if (idx[j] == -2)
        //         continue;
        //     else
        //         idx[j] = -2;
        // }
        // int min = s.length();
        // for (Integer i: idx) {
        //     if (i >= 0 && i < min)
        //         min = i;
        // }
        // return min == s.length() ? -1: min;

        LinkedHashMap<Character, Integer> count = new LinkedHashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}
// @lc code=end

