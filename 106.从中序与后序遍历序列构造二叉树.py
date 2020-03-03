#
# @lc app=leetcode.cn id=106 lang=python3
#
# [106] 从中序与后序遍历序列构造二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def get_node(p_ord, i_ord):
            if i_ord == None or len(i_ord) == 0:
                return None
            root_val = p_ord[-1]
            root = TreeNode(root_val)
            idx = i_ord.index(root_val)
            del p_ord[-1]
            root.right = get_node(p_ord, i_ord[idx + 1:])
            root.left = get_node(p_ord, i_ord[:idx])
            return root
        return get_node(postorder, inorder)
# @lc code=end
