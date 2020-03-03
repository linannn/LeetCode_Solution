#
# @lc app=leetcode.cn id=82 lang=python3
#
# [82] 删除排序链表中的重复元素 II
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
        cur = root
        nex = cur.next
        while nex and nex.next:
            flag = False
            while nex and nex.next and nex.val == nex.next.val:
                flag = True
                nex = nex.next
            if flag:
                nex = nex.next
                cur.next = nex
                continue
            else:
                cur.next = nex
                cur = nex
                nex = nex.next
        return root.next

# @lc code=end
