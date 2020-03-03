/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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

 //        root = ListNode(-float('inf'))
        // root.next = head
        // last = root
        // first = last.next
        // while first:
        //     while first.next and first.val == first.next.val:
        //         first = first.next
        //     last.next = first
        //     last = last.next
        //     first = first.next

        // return root.next
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-Integer.MAX_VALUE);
        root.next = head;
        ListNode last = root;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            last.next = head;
            last = last.next;
            head = head.next;
        }
        return root.next;
    }
}
// @lc code=end

