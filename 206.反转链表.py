#
# @lc app=leetcode.cn id=206 lang=python3
#
# [206] 反转链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        # 递归
        # if not head or not head.next:
        #     return head
        # last = self.reverseList(head.next)
        # head.next.next = head
        # head.next = None
        # return last
        if not head or not head.next:
            return head
        pre = head
        head = head.next
        pre.next = None
        while head:
            tmp = head.next
            head.next = pre
            pre = head

            head = tmp

        return pre

# @lc code=end
