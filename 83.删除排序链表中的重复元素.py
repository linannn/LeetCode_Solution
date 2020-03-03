#
# @lc app=leetcode.cn id=83 lang=python3
#
# [83] 删除排序链表中的重复元素
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        root = ListNode(-float('inf'))
        root.next = head
        last = root
        first = last.next
        while first:
            while first.next and first.val == first.next.val:
                first = first.next
            last.next = first
            last = last.next
            first = first.next

        return root.next
# @lc code=end
