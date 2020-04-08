/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode tail = helper(root);
        tail.left = null;
        tail.right = null;
    }
    private TreeNode helper(TreeNode node) {
        if (node.right == null && node.left == null)
            return node;
        TreeNode right = node.right;
        TreeNode tail = node;
        if (node.left != null) {
            node.right = node.left;
            node.left = null;
            tail =  helper(node.right);
        }
        if (right != null) {
            tail.right = right;
            return helper(tail.right);
        }
        return tail;
    }
}
// @lc code=end

