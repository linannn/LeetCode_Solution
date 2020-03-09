#
# @lc app=leetcode.cn id=145 lang=python3
#
# [145] 二叉树的后序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from typing import List

# 递归
# class Solution:
#     def postorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         self.backward(root, res)
#         return res

#     def backward(self, node, res):
#         if not node:
#             return
#         self.backward(node.left, res)
#         self.backward(node.right, res)
#         res.append(node.val)


class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = [root]
        while stack:
            root = stack.pop()
            if not root:
                continue
            if isinstance(root, TreeNode):
                stack.append(root.val)
                stack.append(root.right)
                stack.append(root.left)
            else:
                res.append(root)
        return res
# @lc code=end
