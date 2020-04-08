#
# @lc app=leetcode.cn id=112 lang=python3
#
# [112] 路径总和
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    # 我的
    # def hasPathSum(self, root: TreeNode, sum: int) -> bool:
    #     if not root:
    #         return False
    #     return self.helper(root, sum)

    # def helper(self, root, sum):
    #     if not root and sum == 0:
    #         return True
    #     if not root and sum != 0:
    #         return False
    #     l = self.helper(root.left, sum - root.val)
    #     r = self.helper(root.right, sum - root.val)
    #     if not root.right:
    #         return l
    #     if not root.left:
    #         return r
    #     return l or r
    # 递归
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        sum -= root.val
        if not root.left and not root.right:
            return sum == 0
        return self.hasPathSum(root.left, sum) or \
            self.hasPathSum(root.right, sum)

# @lc code=end
