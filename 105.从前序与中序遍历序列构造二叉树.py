#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def get_node(p_ord, i_ord):
            if i_ord == None or len(i_ord) == 0:
                return None
            root_val = p_ord[0]
            root = TreeNode(root_val)
            idx = i_ord.index(root_val)
            del p_ord[0]
            root.left = get_node(p_ord, i_ord[:idx])
            root.right = get_node(p_ord, i_ord[idx + 1:])
            return root
        return get_node(preorder, inorder)
# @lc code=end
