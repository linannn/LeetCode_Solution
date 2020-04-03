#
# @lc app=leetcode.cn id=104 lang=python3
#
# [104] 二叉树的最大深度
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # 迭代
        # if root is None:
        #     return 0
        # que = deque()
        # que.append(root)
        # que.append(None)
        # depth = 0
        # while len(que) != 0:
        #     node = que.popleft()
        #     if node is None:
        #         depth += 1
        #         if len(que) != 0:
        #             que.append(None)
        #     elif isinstance(node, TreeNode):
        #         if node.right:
        #             que.append(node.right)
        #         que.append(node.val)
        #         if node.left:
        #             que.append(node.left)
        # return depth-1

        # 递归
        if root is None:
            return 0
        else:
            l_depth = self.maxDepth(root.left)
            r_depth = self.maxDepth(root.right)
            return max(l_depth, r_depth) + 1
# @lc code=end
