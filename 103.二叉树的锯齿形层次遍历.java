/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        queue.offer(root);
        queue.offer(null);
        TreeNode node;
        boolean flag = true;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node != null) {
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                if (!flag) {
                    Collections.reverse(level);
                }
                res.add(level);
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
                level = new ArrayList<>();
                flag = !flag;
            }
        }
        return res;
    }
}
// @lc code=end

