/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> li = new Stack<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return res;
        helper(root, sum);
        return res;
    }
    
    private void helper(TreeNode node, int s) {
        if (node == null)
            return;
        s -= node.val;
        li.push(node.val);
        if (node.left == null && node.right == null && s == 0) {
            res.add(new ArrayList<>(li));
            li.pop();
            return;
        }
        helper(node.left, s);
        helper(node.right, s);
        li.pop();
    }
}
// @lc code=end

