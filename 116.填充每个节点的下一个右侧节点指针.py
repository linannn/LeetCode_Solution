#
# @lc app=leetcode.cn id=116 lang=python3
#
# [116] 填充每个节点的下一个右侧节点指针
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
    def connect(self, root: 'Node') -> 'Node':
        # 我的
        # if not root:
        #     return None
        # queue = deque()
        # queue.append(root)
        # queue.append(None)
        # while len(queue) != 0:
        #     node = queue.popleft()
        #     if node:
        #         node.next = queue[0]
        #         if node.left:
        #             queue.append(node.left)
        #         if node.right:
        #             queue.append(node.right)
        #     else:
        #         if len(queue) != 0:
        #             queue.append(None)
        # return root
        if not root:
            return root

        leftmost = root

        while leftmost.left:
            head = leftmost
            while head:
                head.left.next = head.right
                if head.next:
                    head.right.next = head.next.left
                head = head.next
            leftmost = leftmost.left

        return root

# @lc code=end
