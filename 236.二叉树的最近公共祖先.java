/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    private TreeNode ans;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if ((l && r) || (root.val == p.val || root.val == q.val) && (l || r)) {
            ans = root;
        }
        return l || r || (root.val == p.val || root.val == q.val);
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
        
    }
}
// @lc code=end

