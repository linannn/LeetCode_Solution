/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode(-Integer.MAX_VALUE);
        root.next = head;
        ListNode lastNode = root;
        ListNode searchNode;
        ListNode nextNode;
        ListNode tmp;
        while (head != null) {
            nextNode = head.next;
            if (head.val >= lastNode.val) {
                lastNode = lastNode.next;
            } else {
                searchNode = root;
                while (searchNode.next != head) {
                    if (head.val <= searchNode.next.val) {
                        tmp = searchNode.next;
                        searchNode.next = head;
                        head.next = tmp;
                        lastNode.next = nextNode;
                        break;
                    }
                    searchNode = searchNode.next;
                }
            }
            head = nextNode;
        }
        return root.next;
    }
}
// @lc code=end

