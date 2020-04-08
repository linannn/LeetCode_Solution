#
# @lc app=leetcode.cn id=114 lang=python3
#
# [114] 二叉树展开为链表
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def helper(node):
            if not node.left and not node.right:
                return node
            right = node.right
            tail = node
            if node.left:
                node.right = node.left
                tail.left = None
                tail = helper(node.right)
            if right:
                tail.right = right
                return helper(tail.right)
            return tail
        if not root:
            return root
        tmp = helper(root)
        tmp.left = None
        tmp.right = None
        return root
# @lc code=end
