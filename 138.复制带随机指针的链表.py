#
# @lc app=leetcode.cn id=138 lang=python3
#
# [138] 复制带随机指针的链表
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""


class Solution:

    def copyRandomList(self, head: 'Node') -> 'Node':
        dict = {}

        root = Node(-1)
        root.next = head
        copy_root = Node(-1)
        cur = copy_root
        while root:
            if root.next:
                if root.next not in dict:
                    dict[root.next] = Node(root.next.val)
                cur.next = dict[root.next]
            if root.random:
                if root.random not in dict:
                    dict[root.random] = Node(root.random.val)
                cur.random = dict[root.random]
            root = root.next
            cur = cur.next
        return copy_root.next


# @lc code=end
