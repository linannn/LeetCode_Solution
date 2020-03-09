#
# @lc app=leetcode.cn id=173 lang=python3
#
# [173] 二叉搜索树迭代器
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        if root:
            self.stack.append(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        while self.stack:
            node = self.stack.pop()
            if isinstance(node, TreeNode):
                if node.right:
                    self.stack.append(node.right)
                self.stack.append(node.val)
                if node.left:
                    self.stack.append(node.left)
            else:
                return node

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
# @lc code=end
