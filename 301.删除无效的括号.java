/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String str) {
        Set<String> set = new HashSet<>();
        Set<String> next = new HashSet<>();
        set.add(str);
        List<String> res = new ArrayList<>();
        while (true) {
            for (String s: set) {
                if(isValid(s))
                    res.add(s);
            }
            if (res.size() > 0)
                return res;
            next.clear();
            for (String s : set) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(' || s.charAt(i) == ')')
                        next.add(s.substring(0, i) + s.substring(i+1));
                }
            }
            set = new HashSet<>(next);

        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    
}
// @lc code=end

