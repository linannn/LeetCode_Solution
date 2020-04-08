#
# @lc app=leetcode.cn id=117 lang=python3
#
# [117] 填充每个节点的下一个右侧节点指针 II
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque


class Solution:
    # 我的
    # def connect(self, root: 'Node') -> 'Node':
    #     if not root:
    #         return None
    #     queue = deque()
    #     queue.append(root)
    #     queue.append(None)
    #     while len(queue) != 0:
    #         node = queue.popleft()
    #         if node:
    #             node.next = queue[0]
    #             if node.left:
    #                 queue.append(node.left)
    #             if node.right:
    #                 queue.append(node.right)
    #         else:
    #             if len(queue) != 0:
    #                 queue.append(None)
    #     return root
    def processChild(self, childNode, prev, leftmost):
        if childNode:
            if prev:
                prev.next = childNode
            else:
                leftmost = childNode
            prev = childNode
        return prev, leftmost

    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        leftmost = root
        while leftmost:
            prev, curr = None, leftmost
            leftmost = None
            while curr:
                prev, leftmost = self.processChild(curr.left, prev, leftmost)
                prev, leftmost = self.processChild(curr.right, prev, leftmost)
                curr = curr.next
        return root
# @lc code=end
