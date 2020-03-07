#
# @lc app=leetcode.cn id=725 lang=python3
#
# [725] 分隔链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def splitListToParts(self, root: ListNode, k: int) -> List[ListNode]:
        res = []
        length = self.len(root)
        min_size = length // k
        plus_num = length - min_size * k
        for i in range(plus_num):
            res.append(root)
            for j in range(min_size):
                root = root.next
            tmp = root.next
            root.next = None
            root = tmp
        for i in range(k - plus_num):
            if root:
                res.append(root)
                for j in range(min_size-1):
                    root = root.next
                tmp = root.next
                root.next = None
                root = tmp
            else:
                res.append(None)
        return res

    def len(self, l):
        length = 0
        while l:
            length += 1
            l = l.next
        return length
# @lc code=end
