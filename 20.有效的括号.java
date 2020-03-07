/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
import java.util.Stack;
import java.util.HashMap;

class Solution {
    private static HashMap<Character, Character> map;
    static {
        map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i< s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (map.get(stack.pop()) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
// @lc code=end

