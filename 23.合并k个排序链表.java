/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
import java.util.*;
class MyList implements Comparable<MyList> {
    ListNode node;

    public MyList(ListNode node) {
        this.node = node;
    }

    @Override
    public int compareTo(MyList o) {
        return node.val - o.node.val;
    }
}
class Solution {
    // 我的
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists == null || lists.length == 0)
    //         return null;
    //     if (lists.length == 1)
    //         return lists[0];
    //     ListNode res = lists[0];
    //     for (int i = 1; i < lists.length; i++) {
    //         res = mergeTwoLists(res, lists[i]);
    //     }
    //     return res;

    // }
    // private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     ListNode head = new ListNode(-1);
    //     ListNode cur = head;
    //     while (l1 != null || l2 != null) {
    //         if (l1 == null) {
    //             cur.next = l2;
    //             break;
    //         }
    //         if (l2 == null) {
    //             cur.next = l1;
    //             break;
    //         }
    //         if (l1.val <= l2.val) {
    //             cur.next = l1;
    //             l1 = l1.next;
    //         } else {
    //             cur.next = l2;
    //             l2 = l2.next;
    //         }
    //         cur = cur.next;
    //     }
    //     return head.next;
    // }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<MyList> q = new PriorityQueue<>();
        for (ListNode l : lists) {
            if (l != null)
                q.offer(new MyList(l));
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (q.peek() != null) {
            MyList tmp = q.poll();
            cur.next = tmp.node;
            cur = cur.next;
            if (tmp.node.next != null) {
                q.offer(new MyList(tmp.node.next));
            }
        }
        return head.next;
    }
}
// @lc code=end

