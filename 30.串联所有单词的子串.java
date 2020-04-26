/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=  new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0)
            return res;
        int wordLen = words[0].length();
        Map<String, Integer> oriWords = new HashMap<>();
        for (String w : words) {
            int count = oriWords.getOrDefault(w, 0);
            oriWords.put(w, count+1);
        }
        for (int i = 0; i < s.length()-wordNum*wordLen+1; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            int matchNum = 0;
            for (matchNum = 0; matchNum < wordNum; matchNum ++) {
                String w = s.substring(i+matchNum*wordLen, 
                i+matchNum*wordLen + wordLen);
                if (oriWords.containsKey(w)) {
                    int count = tmp.getOrDefault(w, 0);
                    tmp.put(w, count+1);
                    if (tmp.get(w) > oriWords.get(w))
                        break;
                } else {
                    break;
                }
            }
            if (matchNum == wordNum)
                res.add(i);
        }
        return res;
        
    }
}
// @lc code=end

