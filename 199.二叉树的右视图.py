#
# @lc app=leetcode.cn id=199 lang=python3
#
# [199] 二叉树的右视图
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res = []
        if root is None:
            return res
        from collections import deque
        queue = deque([root, None])
        while len(queue) != 0:
            node = queue.popleft()
            if node:
                if queue[0] is None:
                    res.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            else:
                if len(queue) > 0:
                    queue.append(None)
        return res
# @lc code=end
