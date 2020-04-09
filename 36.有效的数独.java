/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
import java.util.HashSet;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet[] colSet = new HashSet[9];
        HashSet[] rowSet = new HashSet[9];
        HashSet[] unitSet = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            colSet[i] = new HashSet<Character>();
            rowSet[i] = new HashSet<Character>();
            unitSet[i] = new HashSet<Character>();
        }
        char tmp;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmp = board[i][j];
                if (tmp == '.')
                    continue;
                if (colSet[j].contains(tmp) || rowSet[i].contains(tmp)
                || unitSet[(i / 3 ) * 3 + j / 3].contains(tmp)){
                    return false;
                }
                else{
                    colSet[j].add(tmp);
                    rowSet[i].add(tmp);
                    unitSet[(i / 3 ) * 3 + j / 3].add(tmp);
                }
            }

        }
        return true;
    }
}
// @lc code=end

