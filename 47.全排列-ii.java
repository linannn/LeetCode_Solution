/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
import java.util.*;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        helper(new LinkedList<>(), 0);
        return res;
    }
    private void helper(LinkedList<Integer> l, int depth) {
        if (depth == nums.length)
            res.add(generator(l));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (l.contains(i) || set.contains(nums[i]))
                continue;
            l.add(i);
            set.add(nums[i]);
            helper(l, depth + 1);
            l.removeLast();
        }

    }
    private List<Integer> generator(LinkedList<Integer> l) {
        List<Integer> newList = new ArrayList<>();
        for (int i : l) {
            newList.add(nums[i]);
        }
        return newList;
    }
}
// @lc code=end

