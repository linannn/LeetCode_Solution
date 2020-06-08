/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
public class Codec {

    // Encodes a tree to a single string.
    private int idx = 0;

    public String serialize(TreeNode root) {
        if (root == null){
            return "%,";
        }
        String s = root.val + ",";
        return s + serialize(root.left) + serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserialize(arr);
    }
    private TreeNode deserialize(String[] data) {
        if (data[idx].charAt(0) == '%') {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[idx]));
        idx++;
        if (idx < data.length) {
            root.left = deserialize(data);
            root.right = deserialize(data);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

