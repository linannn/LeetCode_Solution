/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    //  # def tree(self, t: TreeNode) -> str:
    // #     if not t:
    // #         return ''
    // #     res = '{}'.format(t.val)
    // #     if not t.left and not t.right:
    // #         return res
    // #     res += '('
    // #     res += self.tree(t.left)
    // #     res += ')'
    // #     if t.right:
    // #         res += '('
    // #         res += self.tree(t.right)
    // #         res += ')'
    // #     return res
class Solution {
    public String tree2str(TreeNode t) {
        return tree(t).toString();

    }
    private StringBuilder tree(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null)
            return sb;
        sb.append(t.val);
        if (t.left == null && t.right == null)
            return sb;
        sb.append('(');
        sb.append(tree(t.left));
        sb.append(')');
        if (t.right != null) {
            sb.append('(');
            sb.append(tree(t.right));
            sb.append(')');
        }
        return sb;
    }
}
// @lc code=end

