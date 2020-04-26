/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = head;
    //     ListNode pre = dummy;
    //     ListNode end = dummy;
    //     while (end.next != null) {
    //         for (int i = 0; i < k && end != null; i++)
    //             end = end.next;
    //         if (end == null)
    //             break;
    //         ListNode start = pre.next;
    //         ListNode next = end.next;
    //         end.next = null;
    //         pre.next = reverse(start);
    //         start.next = next;
    //         pre = start;
    //         end = start;
    //     }
    //     return dummy.next;
    // }

    // private ListNode reverse(ListNode head) {
    //     ListNode pre = null;
    //     while (head != null) {
    //         ListNode next = head.next;
    //         head.next = pre;
    //         pre = head;
    //         head = next;
    //     }
    //     return pre;
    // }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = new ListNode(-1);
        if (head == null)
            return null;
        ListNode start, end;
        start = end = head;
        for (int i = 0; i < k-1 && end != null; i++) {

            end = end.next;
        }
        if (end == null)
            return head;
        ListNode next = end.next;
        end.next = null;
        tmp.next = reverse(start);
        start.next = reverseKGroup(next, k);
        return tmp.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
// @lc code=end

