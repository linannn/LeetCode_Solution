/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    private Node prev = null;
    private Node leftMost = null;
    public Node connect(Node root) {
        if (root == null)
            return root;
        leftMost = root;
        while (leftMost != null) {
            Node curr = leftMost;
            prev = null;
            leftMost = null;
            while (curr != null) {
                helper(curr.left);
                helper(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }
    private void helper(Node child) {
        if (child != null) {
            if (prev != null)
                prev.next = child;
            else 
                leftMost = child;
            
            prev = child;
        }
    }
}
// @lc code=end

