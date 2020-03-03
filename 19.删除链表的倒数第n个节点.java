/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
// root = ListNode(0)
// root.next = head
// start = root
// end = root
// for i in range(n):
// end = end.next
// while end.next != None:
// start = start.next
// end = end.next
// start.next = start.next.next if start.next.next != None else None
// return root.next
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode start = root;
        ListNode end = root;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return root.next;
    }
}
// @lc code=end
