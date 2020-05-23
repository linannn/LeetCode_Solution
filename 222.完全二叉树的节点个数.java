/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        if (l == r) {
            return countNodes(root.right) + (1 << l);
        } else {
            return countNodes(root.left) + (1 << r);
        }
    }

    private int depth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth ++;
            root = root.left;
        }
        return depth;
    }
}
// @lc code=end

