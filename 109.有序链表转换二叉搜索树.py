#
# @lc app=leetcode.cn id=109 lang=python3
#
# [109] 有序链表转换二叉搜索树
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归
# class Solution:
#     def findMiddle(self, head):
#         prev = None
#         slow = head
#         fast = head
#         while fast and fast.next:
#             prev = slow
#             slow = slow.next
#             fast = fast.next.next
#         if prev:
#             prev.next = None
#         return slow

#     def sortedListToBST(self, head: ListNode) -> TreeNode:
#         if not head:
#             return None
#         mid = self.findMiddle(head)
#         root = TreeNode(mid.val)
#         if mid.val == head.val:
#             return root
#         root.left = self.sortedListToBST(head)
#         root.right = self.sortedListToBST(mid.next)
#         return root

# 数组
import math


class Solution:
    def __init__(self):
        self.arr = []

    def toArray(self, head):
        while head:
            self.arr.append(head.val)
            head = head.next

    def sortedListToBST(self, head: ListNode) -> TreeNode:
        self.toArray(head)
        return self.arrayToBST(0, len(self.arr) - 1)

    def arrayToBST(self, start, end):
        if end < start:
            return None
        mid_idx = math.ceil((start + end) / 2)
        root = TreeNode(self.arr[mid_idx])
        if end == start:
            return root
        root.left = self.arrayToBST(start, mid_idx-1)
        root.right = self.arrayToBST(mid_idx+1, end)

        return root


# @lc code=end
