#
# @lc app=leetcode.cn id=129 lang=python3
#
# [129] 求根到叶子节点数字之和
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        nums = []

        def helper(node, n):
            if node.left is None and node.right is None:
                nums.append(n*10 + node.val)
                return
            if node.left:
                helper(node.left, n*10+node.val)
            if node.right:
                helper(node.right, n*10+node.val)
        if root:
            helper(root, 0)
        return sum(nums)
# @lc code=end
