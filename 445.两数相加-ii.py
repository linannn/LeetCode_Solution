#
# @lc app=leetcode.cn id=445 lang=python3
#
# [445] 两数相加 II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l1_len = self.len(l1)
        l2_len = self.len(l2)
        l1 = self.addNode(l1)
        l2 = self.addNode(l2)
        root = ListNode(0)
        res = root
        l1_l2 = l1_len - l2_len
        if l1_l2 > 0:
            while l1_l2:
                l2 = self.addNode(l2)
                l1_l2 -= 1
        else:
            while l1_l2:
                l1 = self.addNode(l1)
                l1_l2 += 1
        self.add(l1, l2)
        res.next = l1
        if res.next.val == 0:
            res = res.next
        return res.next

    def addNode(self, l):
        tmp = ListNode(0)
        tmp.next = l
        return tmp

    def len(self, l):
        length = 0
        tmp = l
        while tmp:
            length += 1
            tmp = tmp.next
        return length

    def add(self, l1, l2):
        if l1:
            _sum = l1.val + l2.val + self.add(l1.next, l2.next)
            l1.val = _sum % 10
            return _sum // 10
        else:
            return 0

# @lc code=end
