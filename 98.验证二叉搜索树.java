/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, -Long.MAX_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode node, long lower, long upper) {
        if (node == null)
            return true;
        int val = node.val;
        if (val <= lower || val >= upper)
            return false;
        if (!helper(node.left, lower, val))
            return false;
        if (!helper(node.right, val, upper))
            return false;
        return true;
    }   
}
// @lc code=end

