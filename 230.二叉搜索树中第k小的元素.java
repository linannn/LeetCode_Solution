/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
import java.util.*;
class Solution {
    // public int kthSmallest(TreeNode root, int k) {
    //     int leftNum = childNum(root.left);
    //     int tmp = k - 1;
    //     if (leftNum == tmp) {
    //         return root.val;
    //     } else if (leftNum < tmp) {
    //         return kthSmallest(root.right, k - leftNum - 1);
    //     } else {
    //         return kthSmallest(root.left, k);
    //     }

    // }
    // private int childNum(TreeNode root) {
    //     if (root == null)
    //         return 0;
    //     return childNum(root.left) + childNum(root.right) + 1;
    // }
    // public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
    //     if (root == null) return arr;
    //     inorder(root.left, arr);
    //     arr.add(root.val);
    //     inorder(root.right, arr);
    //     return arr;
    // }

    // public int kthSmallest(TreeNode root, int k) {
    //     ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
    //     return nums.get(k - 1);
    // }
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) 
            return root.val;
            root = root.right;
        }
    }
}
// @lc code=end

