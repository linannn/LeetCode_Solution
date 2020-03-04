/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.List;
import java.util.ArrayList;
class Solution {
    private List<Integer> arr = new ArrayList<>();

    private void toArray(ListNode head){
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        toArray(head);
        return arrayToBST(0, arr.size()-1);
    }

    private TreeNode arrayToBST(int start, int end) {
        if (end < start) {
            return null;
        }
        int midIdx = (int) Math.ceil((start+end)/2.0);
        TreeNode root = new TreeNode(arr.get(midIdx));
        if (start == end) {
            return root;
        }
        root.left = arrayToBST(start, midIdx-1);
        root.right = arrayToBST(midIdx+1, end);
        return root;
    }
}
// @lc code=end

