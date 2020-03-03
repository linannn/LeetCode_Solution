#
# @lc app=leetcode.cn id=24 lang=python3
#
# [24] 两两交换链表中的节点
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#         self.next = None


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        # 我的
        # root = ListNode(0)
        # root.next = ListNode(0)
        # root.next.next = ListNode(0)
        # root.next.next.next = head
        # first = root.next.next
        # last = root
        # while not (first is None or last is None):
        #     tmp = last.next
        #     last.next = first
        #     tmp2 = first.next
        #     first.next = tmp
        #     tmp.next = tmp2
        #     try:
        #         first = first.next.next.next
        #     except:
        #         break
        #     last = last.next.next
        # return root.next.next.next

        root = ListNode(0)
        root.next = head
        cur = root
        while head and head.next:
            first = head
            second = head.next
            cur.next = second
            first.next = second.next
            second.next = first
            cur = cur.next.next
            head = head.next
        return root.next


# @lc code=end
