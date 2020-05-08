/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
TreeNode first = null;
TreeNode second = null;
TreeNode pre = null;
public void recoverTree(TreeNode root) {
    inorderTraversal(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}
private void inorderTraversal(TreeNode root) {
    if (root == null) {
        return;
    }
    inorderTraversal(root.left); 
    if(pre != null && root.val < pre.val) {
        if(first==null){
            first = pre;
            second = root;
        }else{
            second = root;
        }
    }
    pre = root; 
    inorderTraversal(root.right);
}
}
// @lc code=end

