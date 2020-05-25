/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    List<String> res = new ArrayList<>();
    // public List<String> binaryTreePaths(TreeNode root) {
    //     if (root == null) 
    //         return res;
    //     LinkedList<Integer> li = new LinkedList<>();
    //     helper(root, li);
    //     return res;
    // }
    // private void helper(TreeNode root, LinkedList<Integer> li) {
    //     if (root.left == null && root.right == null) {
    //         li.add(root.val);
    //         insert(li);
    //         li.removeLast();
    //         return;
    //     }
    //     li.add(root.val);
    //     if (root.left != null) {
    //         helper(root.left, li);
    //     }
    //     if (root.right != null) {
    //         helper(root.right, li);
    //     }
    //     li.removeLast();
    // }
    // private void insert(LinkedList<Integer> li) {
    //     StringBuilder b = new StringBuilder();
    //     for (int i: li) {
    //         b.append(i);
    //         b.append("->");
    //     }
    //     b.delete(b.length()-2, b.length());
    //     res.add(b.toString());
    // }
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return res;
    }
    private void helper(TreeNode root, String path) {
        if (root != null) {
            path += Integer.valueOf(root.val);
            if (root.left == null && root.right == null) {
                res.add(path);
            } else {
                path += "->";
                helper(root.left, path);
                helper(root.right, path);
            }
        }
    }

}
// @lc code=end

