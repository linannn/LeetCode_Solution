/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
import java.util.ArrayList;
class Solution {
    ArrayList<String> res = new ArrayList<>();
    ArrayList<String> li = new ArrayList<>();
    int len = 0;
    String s = "";
    public List<String> restoreIpAddresses(String s) {
        this.len = s.length();
        this.s = s;
        backtrack(0, 1, 0);
        return res;
    }
    private void backtrack(int start, int end, int depth) {
        if (start > len-1)
            return;
        if (depth == 3) {
            if (len - start > 3)
                return;
            int tmp = Integer.parseInt(s.substring(start));
            if (start < len -1 && s.charAt(start) == '0')
                return;
            if (tmp <= 255) {
                li.add(s.substring(start));
                res.add(geneString());
                li.remove(depth);
            }
            return;
        } else {
            if (end > len - 1 || Integer.parseInt(s.substring(start, end)) > 255)
                return;
            li.add(s.substring(start, end));
            backtrack(end, end + 1, depth + 1);
            li.remove(depth);
            if (s.charAt(start) != '0')
                backtrack(start, end+1, depth);
        }
    }

    private String geneString() {
        StringBuilder builder = new StringBuilder(li.get(0));
        for (int i = 1; i < li.size(); i++) {
            builder.append('.');
            builder.append(li.get(i));
        }
        return builder.toString();
    }

}
// @lc code=end

