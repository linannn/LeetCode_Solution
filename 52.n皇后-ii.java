/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    private List<List<String>> res = new ArrayList<>();
    private boolean[] obliqueRight;
    private boolean[] col;
    private boolean[] obliqueLeft;
    private int n;

    public int totalNQueens(int n) {
        col = new boolean[n];
        obliqueRight = new boolean[2 * n];
        obliqueLeft = new boolean[2 * n];
        this.n = n;
        helper(new LinkedList<>(), 0);
        return res.size();
    }

    private void helper(LinkedList<LinkedList<String>> process, int depth) {
        if (depth >= n)
            writeRes(process);
        LinkedList<String> line = new LinkedList<>();
        process.add(line);
        for (int i = 0; i < n; i++) {
            int left = n + i - depth;
            int right = i + depth;
            if (col[i] || obliqueLeft[left] || obliqueRight[right]) {
                line.add(".");
            } else {
                line.add("Q");
                col[i] = obliqueLeft[left] = obliqueRight[right] = true;
                helper(process, depth + 1);
                col[i] = obliqueLeft[left] = obliqueRight[right] = false;
                line.removeLast();
                line.add(".");
            }
        }
        process.removeLast();
    }

    private void writeRes(LinkedList<LinkedList<String>> process) {
        List<String> aRes = new ArrayList<>();
        for (List<String> l : process) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(i < l.size() ? l.get(i) : ".");
            }
            aRes.add(sb.toString());
        }
        res.add(aRes);

    }

}
// @lc code=end

