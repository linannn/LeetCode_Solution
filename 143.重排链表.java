/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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

//  node_map = {}
//         idx = 1
//         while head:
//             node_map[idx] = head
//             head = head.next
//             node_map[idx].next = None
//             idx += 1
//         if idx <= 2:
//             return
//         for i in range(idx // 2-1):
//             node_map[i + 1].next = node_map[idx - i - 1]
//             node_map[idx - i - 1].next = node_map[i + 2]

//         if idx % 2 == 1:
//             node_map[idx // 2].next = node_map[idx // 2 + 1]

import java.util.HashMap;
class Solution {
    public void reorderList(ListNode head) {
        HashMap<Integer, ListNode> nodeMap = new HashMap<>();
        int idx = 1;
        while (head != null) {
            nodeMap.put(idx, head);
            head = head.next;
            nodeMap.get(idx).next = null;
            idx ++;
        }
        if (idx <= 2) {
            return;
        }
        int midIdx = (int) Math.floor(idx/2);
        for (int i = 0; i < midIdx-1; i++) {
            nodeMap.get(i+1).next = nodeMap.get(idx-1-i);
            nodeMap.get(idx-i-1).next = nodeMap.get(i+2);
        }
        if (idx % 2 == 1) {
            nodeMap.get(midIdx).next = nodeMap.get(midIdx+1);
        }

    }
}
// @lc code=end

