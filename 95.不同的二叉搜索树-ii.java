/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.List;
import java.util.ArrayList; 
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);

    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        } 
        for (int i = start; i < end + 1; i++) {
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            for (TreeNode lNode:left) {
                for (TreeNode rNode:right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = lNode;
                    cur.right = rNode;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
// @lc code=end

