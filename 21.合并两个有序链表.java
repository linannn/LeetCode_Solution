/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-Integer.MAX_VALUE);
        root.next = l1;
        l1 = root;
        ListNode l1_next = l1.next;
        while (l2 != null) {
            while (l1_next != null && l1_next.val <= l2.val) {
                l1 = l1_next;
                l1_next = l1_next.next;
            }
            if (l2 != null) {
                l1.next = l2;
                l2 = l2.next;
                l1.next.next = l1_next;
                l1 = l1.next;
            }
            if (l1_next == null){
                l1.next = l2;
            }
        }
        return root.next;

    }
}
// @lc code=end

