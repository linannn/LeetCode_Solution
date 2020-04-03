#
# @lc app=leetcode.cn id=107 lang=python3
#
# [107] 二叉树的层次遍历 II
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
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        res = []
        que = deque()
        que.append(root)
        que.append(None)
        level = []
        while len(que) > 0:
            node = que.popleft()
            if node is None:
                res.append(level)
                level = []
                if len(que) > 0:
                    que.append(None)
            else:
                level.append(node.val)
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
        return list(reversed(res))

# @lc code=end
