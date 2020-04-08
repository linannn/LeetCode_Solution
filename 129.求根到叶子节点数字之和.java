/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
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
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root != null)
            helper(root, 0);
        return res;
    }
    private void helper(TreeNode root, int n) {
        int tmp =  n * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += tmp;
        }
        if (root.left != null)
            helper(root.left, tmp);
        if (root.right != null) 
            helper(root.right, tmp);
    }
}
// @lc code=end

