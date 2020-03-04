#
# @lc app=leetcode.cn id=147 lang=python3
#
# [147] 对链表进行插入排序
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        root = ListNode(-float('inf'))
        root.next = head
        last = root
        while head:
            search = root
            nex = head.next
            if head.val >= last.val:
                last = last.next
            else:
                while search.next != head:
                    if head.val <= search.next.val:
                        tmp = search.next
                        search.next = head
                        head.next = tmp
                        last.next = nex
                        break
                    search = search.next
            head = nex

        return root.next

# @lc code=end
