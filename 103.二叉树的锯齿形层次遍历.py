#
# @lc app=leetcode.cn id=103 lang=python3
#
# [103] 二叉树的锯齿形层次遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
from typing import List


class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root:
            return res
        level = deque()
        que = deque()
        que.append(root)
        que.append(None)
        flag = False
        while que:
            node = que.popleft()
            if node:
                if flag:
                    level.append(node.val)
                else:
                    level.appendleft(node.val)
                if node.right:
                    que.append(node.right)
                if node.left:
                    que.append(node.left)
            else:
                res.append(list(level))
                if que:
                    que.append(None)
                level = deque()
                flag = not flag
        return res
# @lc code=end
