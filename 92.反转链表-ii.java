/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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

        //  root = ListNode(0)
        // root.next = head
        // start = head
        // end = root
        // cur = None
        // idx = 1
        // while head:
        //     if idx < m:
        //         end = head
        //         head = head.next
        //         idx += 1
        //     elif idx == m:
        //         start = head
        //         cur = head
        //         head = head.next
        //         cur.next = None
        //         idx += 1
        //     elif idx <= n:
        //         tmp = head.next
        //         head.next = cur
        //         cur = head
        //         head = tmp
        //         idx += 1
        //     if idx > n:
        //         start.next = head
        //         end.next = cur
        //         break

        // return root.next
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode start = head;
        ListNode tail = root;
        ListNode cur = null;
        ListNode tmp = null;
        int idx = 1;
        while (head != null) {
            if (idx < m) {
                tail = head;
                head = head.next;
                idx++;
            } else if (idx == m){
                start = head;
                cur = head;
                head = head.next;
                cur.next = null;
                idx ++;
            } else if (idx <= n) {
                tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
                idx ++;
            }
            if (idx > n){
                start.next = head;
                tail.next = cur;
                break;
            }
        }
        return root.next;
    }
}
// @lc code=end

