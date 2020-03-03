#
# @lc app=leetcode.cn id=61 lang=python3
#
# [61] 旋转链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head or not head.next:
            return head
        last = head
        length = 1
        while last.next:
            last = last.next
            length += 1
        k = length - k % length
        last.next = head
        for i in range(k):
            head = head.next
            last = last.next
        last.next = None
        return head
# @lc code=end
