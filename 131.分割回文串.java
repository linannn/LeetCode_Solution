/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
import java.util.*;

class Solution {
    private List<List<String>> res = new ArrayList<>();
    private String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        backtracking(0, new LinkedList<>());
        return res;
    }

    private void backtracking(int start, LinkedList<String> stack) {
        if (start >= s.length()){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPartition(start,i)) {
                continue;
            }
            stack.add(s.substring(start, i+1));
            backtracking(i+1, stack);
            stack.removeLast();
        }
    }
    private boolean isPartition(int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end

