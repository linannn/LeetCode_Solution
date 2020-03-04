#
# @lc app=leetcode.cn id=92 lang=python3
#
# [92] 反转链表 II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        root = ListNode(0)
        root.next = head
        start = head
        end = root
        cur = None
        idx = 1
        while head:
            if idx < m:
                end = head
                head = head.next
                idx += 1
            elif idx == m:
                start = head
                cur = head
                head = head.next
                cur.next = None
                idx += 1
            elif idx <= n:
                tmp = head.next
                head.next = cur
                cur = head
                head = tmp
                idx += 1
            if idx > n:
                start.next = head
                end.next = cur
                break

        return root.next

# @lc code=end
