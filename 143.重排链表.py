#
# @lc app=leetcode.cn id=143 lang=python3
#
# [143] 重排链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        node_map = {}
        idx = 1
        while head:
            node_map[idx] = head
            head = head.next
            node_map[idx].next = None
            idx += 1
        if idx <= 2:
            return
        for i in range(idx // 2-1):
            node_map[i + 1].next = node_map[idx - i - 1]
            node_map[idx - i - 1].next = node_map[i + 2]

        if idx % 2 == 1:
            node_map[idx // 2].next = node_map[idx // 2 + 1]


# @lc code=end
