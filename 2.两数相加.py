#
# @lc app=leetcode.cn id=2 lang=python3
#
# [2] 两数相加
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        root = ListNode(0)
        cur = root
        nex = 0
        while not (l1 == None and l2 == None and nex == 0):
            l1_val = l1.val if l1 != None else 0
            l2_val = l2.val if l2 != None else 0
            sum_ = l1_val + l2_val + nex
            cur.next = ListNode(sum_ % 10)
            cur = cur.next
            nex = sum_ // 10
            l1 = l1.next if l1 != None else None
            l2 = l2.next if l2 != None else None

        return root.next
# @lc code=end
