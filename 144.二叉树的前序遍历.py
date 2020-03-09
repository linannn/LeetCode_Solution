#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import List


# class Solution:
#     def preorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         self.forward(root, res)
#         return res

#     def forward(self, node, res):
#         if not node:
#             return
#         res.append(node.val)
#         self.forward(node.left, res)
#         self.forward(node.right, res)

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = [root]
        while stack:
            root = stack.pop()
            if not root:
                continue
            res.append(root.val)
            stack.append(root.right)
            stack.append(root.left)
        return res

# @lc code=end
