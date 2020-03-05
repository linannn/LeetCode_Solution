#
# @lc app=leetcode.cn id=160 lang=python3
#
# [160] 相交链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # 太骚了
        pA = headA
        pB = headB
        aPaste = False
        if not (headA and headB):
            return None
        while pA or not aPaste:
            if not pA:
                pA = headB
                aPaste = True
            if not pB:
                pB = headA
            if pA == pB:
                return pA
            pA = pA.next
            pB = pB.next
        return None
        # node_set = set()
        # while headA:
        #     node_set.add(headA)
        #     headA = headA.next
        # while headB:
        #     if headB in node_set:
        #         return headB
        #     headB = headB.next
        # return None
# @lc code=end
