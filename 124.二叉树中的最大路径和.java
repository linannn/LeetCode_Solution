/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    // 我的
//     public int maxPathSum(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int[] res = helper(root);
//         return Math.max(res[0], res[1]);
//     }
//     // 0代表可以向上传递的，1代表不可以向上传递的
//     private int[] helper(TreeNode root) {
//         if (root == null) {
//             return new int[]{0,0};
//         }
//         if (root.left == null && root.right == null) {
//             return new int[]{root.val, root.val};
//         }
//         int[] res = new int[2];
//         if (root.left == null || root.right == null) {
//             int[] left = new int[2];
//             if (root.left == null) {
//                 left = helper(root.right);
//             } else {
//                 left = helper(root.left);
//             }
//             res[0] = max(new int[]{root.val, left[0] + root.val});
//             res[1] = max(new int[]{left[0], root.val + left[0], left[1]});
// //            res[1] = Math.max(left[0] + root.val, left[0]);
//         } else {
//             int[] left = helper(root.left);
//             int[] right = helper(root.right);
//             res[0] = Math.max(root.val, Math.max(left[0], right[0]) + root.val);
//             res[1] = max(new int[]{left[0], left[1], right[1], right[0], right[0] + left[0] + root.val});
//         }
//         return res;
//     }

//     private int max(int[] array) {
//         int res = Integer.MIN_VALUE;
//         for (int value : array) {
//             res = Math.max(res, value);
//         }
//         return res;
//     }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + leftMax + rightMax);
        // 返回经过root的单边最大分支给上游
        return root.val + Math.max(leftMax, rightMax);
    }
}
// @lc code=end

