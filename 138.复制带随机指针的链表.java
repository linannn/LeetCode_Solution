/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.Map;
import java.util.HashMap;
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> dict = new HashMap<>();
        Node root = new Node(-1);
        root.next = head;
        Node copyRoot =  new Node(-1);
        Node cur = copyRoot;
        while (root != null) {
            if (root.next != null) {
                if (!dict.containsKey(root.next)) {
                    dict.put(root.next, new Node(root.next.val));
                }
                cur.next = dict.get(root.next);
            }
            if (root.random != null) {
                if (!dict.containsKey(root.random)) {
                    dict.put(root.random, new Node(root.random.val));
                }
                cur.random = dict.get(root.random);
            }
            root = root.next;
            cur = cur.next;
        }
        return copyRoot.next;
        
    }
}
// @lc code=end

