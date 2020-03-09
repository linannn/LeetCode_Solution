/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         ArrayList<Integer> res = new ArrayList<>();
//         recu(root, res);
//         return res;
//     }
//     private void recu(TreeNode root, ArrayList<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         recu(root.left, res);
//         res.add(root.val);
//         recu(root.right, res);
//     }
// }

//  迭代
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
        // ArrayList<Integer> res = new ArrayList<>();
        // Stack<TreeNode> stack = new Stack<>();
//         while (!stack.empty() || root != null) {
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             res.add(root.val);
//             root = root.right;
//         }
//         return res;
//     }
// }

// 染色法
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            if (stack.peek() == null) {
                stack.pop();
            } else if (stack.peek() instanceof TreeNode) {
                root = (TreeNode) stack.pop();
                stack.push(root.right);
                stack.push(root.val);
                stack.push(root.left);
            } else {
                res.add((int) stack.pop());
            }
        }
        return res;
    }
}


// @lc code=end

