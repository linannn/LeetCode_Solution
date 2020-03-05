#
# @lc app=leetcode.cn id=203 lang=python3
#
# [203] 移除链表元素
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        root = ListNode(-float('inf'))
        root.next = head
        pre = root
        while head:
            if head.val == val:
                pre.next = head.next
                head = head.next
            else:
                head = head.next
                pre = pre.next

        return root.next
# @lc code=end
