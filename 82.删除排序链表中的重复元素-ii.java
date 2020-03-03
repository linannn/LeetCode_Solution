/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-Integer.MAX_VALUE);
        root.next = head;
        ListNode cur = root;
        ListNode next = cur.next;
        boolean flag = false;
        while (next!= null && next.next!=null) {
            flag = false;
            while (next!= null && next.next!=null && next.val == next.next.val) {
                flag = true;
                next = next.next;
            }
            if (flag) {
                next = next.next;
                cur.next = next;
            } else {
                cur.next = next;
                cur = next;
                next = next.next;
            }
        }
        return root.next;
    }
}
// @lc code=end

