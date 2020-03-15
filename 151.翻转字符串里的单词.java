/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // StringBuilder b = new StringBuilder();
        // Arrays.stream(s.split(" ")).filter((item) -> !item.equals("")).forEach(item->{
        //     b.insert(0, item);
        //     b.insert(0, " ");
        // });
        // if (b.length() > 0)
        //     b.deleteCharAt(0);
        // return b.toString();
        StringBuilder b = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length-1; i>=0; i--){
            if (strs[i].length() == 0) continue;
            b.append(strs[i]).append(" ");
        }
        if (b.length()>0) b.deleteCharAt(b.length()-1);
        return b.toString();
    }
}
// @lc code=end

