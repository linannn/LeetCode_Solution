/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
        // # hash表
        // # node_set = set()
        // # while head:
        // #     if head not in node_set:
        // #         node_set.add(head)
        // #     else:
        // #         return True
        // #     head = head.next
        // # return False
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.contains(head)) {
                nodeSet.add(head);
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
// @lc code=end

