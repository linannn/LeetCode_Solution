/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
import java.util.ArrayList;
class Solution {
    String[] _2 = {"a","b","c"};
    String[] _3 = {"d", "e", "f"};
    String[] _4 = {"g", "h", "i"};
    String[] _5 = {"j", "k", "l"};
    String[] _6 = {"m", "n", "o"};
    String[] _7 = {"p", "q", "r", "s"};
    String[] _8 = {"t", "u", "v"};
    String[] _9 = {"w", "x", "y", "z"};
    ArrayList<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits != null && !digits.equals(""))
            backtrack("", digits);
        return res;
    }

    private void backtrack(String comb, String digits) {
        if (digits.equals(""))
            res.add(comb);
        else {
            for (String ch: getCh(digits.charAt(0))) {
                backtrack(comb+ch, digits.substring(1));
            }
        }
    }

    private String[] getCh(char ch) {
        switch(ch) {
            case('2'): return _2;
            case('3'): return _3;
            case('4'): return _4;
            case('5'): return _5;
            case('6'): return _6;
            case('7'): return _7;
            case('8'): return _8;
            case('9'): return _9;
            default: return _2;
        }
    }
}
// @lc code=end
