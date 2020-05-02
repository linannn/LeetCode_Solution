/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineNum = 0;
        int i = 0;
        while (i < words.length) {
            line.add(words[i]);
            lineNum = words[i].length();
            while (i < words.length - 1 && lineNum + 1 + words[i + 1].length() <= maxWidth) {
                line.add(words[i + 1]);
                lineNum += 1 + words[i + 1].length();
                i++;
            }
            if (i == words.length-1) {
                res.add(zuo(line, maxWidth));
            } else {
                res.add(getLine(line, maxWidth));
            }
            line.clear();
            i++;
        }
        return res;
    }

    private String getLine(List<String> strs, int maxWidth) {
        if (strs.size() == 1) {
            return zuo(strs, maxWidth);
        }
        int charNum = 0;
        for (String s : strs) {
            charNum += s.length();
        }
        int spaceNum = maxWidth - charNum;
        int sNum = spaceNum / (strs.size()-1);
        int lSpaceNum = spaceNum % (strs.size()-1);
        StringBuilder sbTmp = new StringBuilder();
        for (int i = 0; i < sNum; i++) {
            sbTmp.append(' ');
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strs.get(0));
        for (int i = 1; i < strs.size(); i++) {
            sb.append(sbTmp);
            if (i - 1 < lSpaceNum)
                sb.append(' ');
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    private String zuo(List<String> strs, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(strs.get(0));
        for (int i = 1; i < strs.size(); i++) {
            sb.append(' ');
            sb.append(strs.get(i));
        }
        int l = sb.length();
        for (int i = 0; i < maxWidth - l; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
// @lc code=end

