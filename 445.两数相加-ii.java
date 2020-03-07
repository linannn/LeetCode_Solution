/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
        l1 = addNode(l1);
        l2 = addNode(l2);
        int lenL1 = listLen(l1);
        int lenL2 = listLen(l2);
        int l1_l2 = lenL1 - lenL2;
        if (l1_l2 > 0) {
            while (l1_l2 != 0) {
                l2 = addNode(l2);
                l1_l2--;
            }
        }
        if (l1_l2 < 0) {
            while (l1_l2 != 0) {
                l1 = addNode(l1);
                l1_l2++;
            }
        }
        add(l1, l2);
        while (l1.val == 0 && l1.next != null) {
            l1 = l1.next;
        }
        return l1;

    }
    private int listLen(ListNode l) {
        ListNode tmp = l;
        int length = 0;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        return length;
    }
    private ListNode addNode(ListNode l) {
        ListNode tmp = new ListNode(0);
        tmp.next = l;
        return tmp;
    }

    private int add(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return 0;
        } else {
            int sum = l1.val + l2.val + add(l1.next, l2.next);
            l1.val = sum % 10;
            return (int)Math.ceil(sum/10);
        }
    }
}
// @lc code=end

