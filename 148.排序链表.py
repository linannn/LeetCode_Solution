#
# @lc app=leetcode.cn id=148 lang=python3
#
# [148] 排序链表
# 跨度

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        h = head
        length = 0
        while h:
            h, length = h.next, length + 1
        root = ListNode(-1)
        root.next = head
        span = 1
        while span <= length:
            pre, h = root, root.next
            while h:
                h1, i = h, span
                while i and h:
                    h, i = h.next, i - 1
                if i:
                    break
                h2, i = h, span
                while i and h:
                    h, i = h.next, i - 1
                c1, c2 = span, span - i
                while c1 and c2:
                    if h1.val < h2.val:
                        pre.next, h1, c1 = h1, h1.next, c1 - 1
                    else:
                        pre.next, h2, c2 = h2, h2.next, c2 - 1
                    pre = pre.next
                pre.next = h1 if c1 else h2
                while c1 > 0 or c2 > 0:
                    pre, c1, c2 = pre.next, c1 - 1, c2 - 1
                pre.next = h
            span *= 2
        return root.next
# @lc code=end
