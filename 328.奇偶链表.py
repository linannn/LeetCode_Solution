#
# @lc app=leetcode.cn id=328 lang=python3
#
# [328] 奇偶链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None 奇数 偶数


class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        # 第一
        # odd_root = ListNode(1)
        # odd = odd_root
        # even_root = ListNode(0)
        # even = even_root
        # idx = 1
        # while head:
        #     if idx % 2 == 1:
        #         odd.next = head
        #         head = head.next
        #         odd.next.next = None
        #         odd = odd.next
        #     else:
        #         even.next = head
        #         head = head.next
        #         even.next.next = None
        #         even = even.next
        #     idx += 1

        # odd.next = even_root.next
        # return odd_root.next
        # 第二

        # odd_root = ListNode(1)
        # odd = odd_root
        # even_root = ListNode(0)
        # even = even_root
        # while head and head.next:
        #     odd.next = head
        #     head = head.next
        #     odd.next.next = None
        #     odd = odd.next
        #     even.next = head
        #     head = head.next
        #     even.next.next = None
        #     even = even.next
        # if head:
        #     odd.next = head
        #     head = head.next
        #     odd.next.next = None
        #     odd = odd.next
        # odd.next = even_root.next
        # return odd_root.next

        # 标准
        if not head:
            return head
        odd = head
        even = head.next
        even_root = even
        while even and even.next:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        odd.next = even_root
        return head

# @lc code=end
