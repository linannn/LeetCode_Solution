#
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from typing import List


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 我的
        # root = ListNode(-float("inf"))
        # root.next = l1
        # l1 = root
        # l1_next = l1.next
        # while l2 != None:
        #     while l1_next != None and l1_next.val <= l2.val:
        #         l1 = l1_next
        #         l1_next = l1_next.next
        #     if l2 != None:
        #         l1.next = ListNode(l2.val)
        #         l1.next.next = l1_next
        #         l1 = l1.next
        #         l2 = l2.next
        #     if l1_next == None:
        #         l1.next = l2
        # return root.next

        # 递归
        # if l1 is None:
        #     return l2
        # elif l2 is None:
        #     return l1
        # elif l1.val < l2.val:
        #     l1.next = self.mergeTwoLists(l1.next, l2)
        #     return l1
        # else:
        #     l2.next = self.mergeTwoLists(l1, l2.next)
        #     return l2
        root = ListNode(-float('inf'))
        cur = root
        while not (l1 is None and l2 is None):
            if l1 is None:
                cur.next = l2
                break
            if l2 is None:
                cur.next = l1
                break
            if l1.val <= l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        return root.next
# @lc code=end
