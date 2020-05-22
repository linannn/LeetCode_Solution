/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
}
class Solution {
    private char[][] board;
    private List<String> res = new ArrayList<>();
    private int[] row = new int[]{0,1,0,-1};
    private int[] col = new int[]{1,0,-1,0};
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.word = word;
        }
        this.board = board;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(this.board[i][j]))
                    helper(i, j, root);
            }
        }
        return res;
    }
    private void helper(int i, int j, TrieNode node) {
        char cur = board[i][j];
        TrieNode curNode = node.children.get(cur);
        if (curNode.word != null) {
            this.res.add(curNode.word);
            curNode.word = null;
        }
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int newI = i+row[k];
            int newJ = j+col[k];
            if (newI < 0 || newI > board.length - 1 || newJ < 0 || newJ > board[0].length - 1) {
                continue;
            }
            if (curNode.children.containsKey(board[newI][newJ]))
                helper(newI, newJ, curNode);
        }
        board[i][j] = cur;
    }

}
// @lc code=end

