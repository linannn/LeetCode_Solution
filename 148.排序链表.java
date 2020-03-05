/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        ListNode h = head;
        int length = 0;
        while (h != null) {
            h = h.next;
            length++;
        }
        ListNode root = new ListNode(-Integer.MAX_VALUE);
        root.next = head;
        ListNode pre, h1, h2;
        int c1, c2, i;
        int span = 1;
        while (span <= length) {
            pre = root;
            h = root.next;
            while (h != null) {
                h1 = h;
                i = span;
                while (h != null && i > 0) {
                    h = h.next;
                    i--;
                }
                if (i != 0) {
                    break;
                }
                h2 = h;
                i = span;
                while (h != null && i > 0) {
                    h = h.next;
                    i--;
                }
                c1 = span;
                c2 = span - i;
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                // 不要忘记这一步
                pre.next = c2 > 0 ? h2 : h1; 
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;
            }
            span = span * 2;
        }
        return root.next;
    }
}
// @lc code=end

