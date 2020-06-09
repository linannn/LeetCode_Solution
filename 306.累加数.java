/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, 0);
    }

    private boolean dfs(String s, int idx, long sum, long pre, int k) {
        if (idx == s.length()) {
            return k > 2;
        }
        for (int i = idx; i < s.length(); i++) {
            long cur = parseNumber(s, idx, i);
            if (cur < 0) {
                return false;
            }
            if (k >= 2 && cur != sum) {
                continue;
            }
            if (dfs(s, i + 1, pre + cur, cur, k + 1)) {
                return true;
            }
        }
        return false;
    }

    private long parseNumber(String s, int start, int end) {
        if (start < end && s.charAt(start) == '0') {
            return -1;
        }
        long res = 0;
        while (start <= end) {
            res = res * 10 + s.charAt(start) - '0';
            start++;
        }
        return res;
    }
}
// @lc code=end

