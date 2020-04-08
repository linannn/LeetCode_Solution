#
# @lc app=leetcode.cn id=113 lang=python3
#
# [113] 路径总和 II
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        def helper(node, s, li=[]):
            if not node:
                return
            s -= node.val
            li.append(node.val)
            if not node.left and not node.right and s == 0:
                res.append(li+[])
                li.pop()
                return
            helper(node.left, s, li)
            helper(node.right, s, li)
            li.pop()
        res = []
        if not root:
            return res
        helper(root, sum)
        return res

# @lc code=end
