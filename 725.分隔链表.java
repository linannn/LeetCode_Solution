/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = len(root);
        ListNode[] res = new ListNode[k];
        int minWidth = (int) Math.ceil(length/k);
        int onePlusNum = length-minWidth*k;
        int size = 0;
        ListNode tmp = null;
        for (int i = 0; i < k; i++) {
            if (root != null) {
                res[i] = root;
                size = i<onePlusNum? minWidth: minWidth-1;
                for (int j = 0; j<size;j++){
                    root = root.next;
                }
                tmp = root.next;
                root.next = null;
                root = tmp;
            } else {
                res[i] = null;
            }
        }
        return res;
    }

    public int len(ListNode l) {
        int length = 0;
        while (l != null) {
            length++;
            l = l.next;
        }
        return length;
    }
}
// @lc code=end

