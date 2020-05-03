/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || k > n)
            return res;
        helper(n, k, 0, new LinkedList<>());
        return res;
    }
    private void helper(int n, int k, int start, LinkedList<Integer> li) {
        if (start > n)
            return;
        if (li.size() == k) {
            res.add(new ArrayList<>(li));
            return;
        }
        li.add(start+1);
        helper(n, k, start+1, li);
        li.removeLast();
        helper(n, k, start+1, li);
    }
}
// @lc code=end

