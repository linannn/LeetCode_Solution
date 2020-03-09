#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from typing import List


class Solution:
    # 递归
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     res = []
    #     if root:
    #         self.mid(root, res)
    #     return res

    # def mid(self, root, res):
    #     if root.left:
    #         self.mid(root.left, res)
    #     res.append(root.val)
    #     if root.right:
    #         self.mid(root.right, res)

    # 迭代
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     res = []
    #     stack = []
    #     while root or stack:
    #         while root:
    #             stack.append(root)
    #             root = root.left
    #         root = stack.pop()
    #         res.append(root.val)
    #         root = root.right
    #     return res

    # 标记法
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = [root]
        while stack:
            node = stack.pop()
            if not node:
                continue
            if isinstance(node, TreeNode):
                stack.append(node.right)
                stack.append(node.val)
                stack.append(node.left)
            else:
                res.append(node)
        return res


# @lc code=end
