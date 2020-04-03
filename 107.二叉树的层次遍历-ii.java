/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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

import java.util.LinkedList;
import java.util.Collections;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) 
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add(level);
                level = new LinkedList<>();
                if (queue.size() > 0)
                    queue.add(null);
            } else {
                level.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

