/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }
    private TreeNode helper(int start, int end) {
        if (start > end)
            return null;
        int mid = (end+start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(start, mid-1);
        root.right = helper(mid+1, end);
        return root;
    }
}
// @lc code=end

