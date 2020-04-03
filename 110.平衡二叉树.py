#
# @lc app=leetcode.cn id=110 lang=python3
#
# [110] 平衡二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        def helper(p):
            if p is None:
                return 0
            left = helper(p.left)
            if left == -1:
                return - 1
            right = helper(p.right)
            if right == -1:
                return - 1
            return max(left, right) + 1 if abs(right-left) < 2 else -1
        return True if helper(root) != -1 else False
# @lc code=end
