#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第N个节点
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        root = ListNode(0)
        root.next = head
        start = root
        end = root
        for i in range(n):
            end = end.next
        while end.next != None:
            start = start.next
            end = end.next
        start.next = start.next.next if start.next.next != None else None
        return root.next
# @lc code=end
