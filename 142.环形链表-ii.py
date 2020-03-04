#
# @lc app=leetcode.cn id=142 lang=python3
#
# [142] 环形链表 II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        node_map = {}
        idx = 1
        while head:
            if head not in node_map:
                node_map[head] = idx
            else:
                return head
            head = head.next
            idx += 1
        return None

# @lc code=end
