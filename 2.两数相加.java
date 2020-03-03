/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // return root.next
        ListNode root = new ListNode(0);
        ListNode cur = root;
        int nex = 0;
        while (!(l1 == null && l2 == null && nex == 0)) {
            int l1_val = l1 != null ? l1.val : 0;
            int l2_val = l2 != null ? l2.val : 0;
            int sum = l1_val + l2_val + nex;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            nex = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return root.next;

    }
}
// @lc code=end
