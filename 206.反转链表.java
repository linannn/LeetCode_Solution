/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // 递归
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode last = reverseList(head.next);
        // head.next.next = head;
        // head.next = null;
        // return last;

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode tmp = null;
        head = head.next;
        pre.next = null;
        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
// @lc code=end

