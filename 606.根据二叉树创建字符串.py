#
# @lc app=leetcode.cn id=606 lang=python3
#
# [606] 根据二叉树创建字符串
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    # 递归
    # def tree2str(self, t: TreeNode) -> str:
    #     return self.tree(t)

    # def tree(self, t: TreeNode) -> str:
    #     if not t:
    #         return ''
    #     res = '{}'.format(t.val)
    #     if not t.left and not t.right:
    #         return res
    #     res += '('
    #     res += self.tree(t.left)
    #     res += ')'
    #     if t.right:
    #         res += '('
    #         res += self.tree(t.right)
    #         res += ')'
    #     return res
    def tree2str(self, t: TreeNode) -> str:
        stack = []
        stack.append(t)
        res = ''
        while stack:
            node = stack.pop()
            if node == None:
                continue
            if isinstance(node, TreeNode):
                if not node.left and not node.right:
                    stack.append(node.val)
                    continue
                if node.right:
                    stack.append(')')
                    stack.append(node.right)
                    stack.append('(')

                stack.append(')')
                stack.append(node.left)
                stack.append('(')
                stack.append(node.val)
            else:
                res += '{}'.format(node)
        return res


# @lc code=end
