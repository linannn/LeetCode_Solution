/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
import java.util.*;
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(new LinkedList<>(), 0, nums);
        return res;
    }
    private void helper(LinkedList<Integer> l, int depth, int[] nums) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(l));
        }
        for (int n: nums) {
            if (l.contains(n)) {
                continue;
            }
            l.add(n);
            helper(l, depth+1, nums);
            l.removeLast();
        }
    }
}
// @lc code=end

