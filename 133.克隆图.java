/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.*;

class Solution {
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(dfs(neighbor));
        }
        return cloneNode;
    }

    // public Node cloneGraph(Node node) {
    //     Map<Node, Node> lookup = new HashMap<>();
    //     return dfs(node, lookup);
    // }

    // private Node dfs(Node node, Map<Node,Node> lookup) {
    //     if (node == null) return null;
    //     if (lookup.containsKey(node)) return lookup.get(node);
    //     Node clone = new Node(node.val, new ArrayList<>());
    //     lookup.put(node, clone);
    //     for (Node n : node.neighbors)clone.neighbors.add(dfs(n,lookup));
    //     return clone;
    // }
}
// @lc code=end

