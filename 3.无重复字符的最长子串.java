/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.ArrayDeque;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!deque.contains(s.charAt(i))) {
                deque.offerLast(s.charAt(i));
            } else {
                res = Math.max(res, deque.size());
                deque.offerLast(s.charAt(i));
                while (deque.pollFirst()!=s.charAt(i));

            }
        }
        return Math.max(res, deque.size());
    }
}
// @lc code=end

