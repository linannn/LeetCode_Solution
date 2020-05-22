/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
import java.util.*;
class WordDictionary {
    private Map<Integer,List<String>> map= new HashMap<>();

    /** Initialize your data structure here. */
    public WordDictionary() {

    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int len = word.length();
        if (!map.containsKey(len)) {
            map.put(len, new ArrayList<>());
        }
        map.get(len).add(word);

    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int len = word.length();
        if (!map.containsKey(len))
            return false;
        int i;
        for (String s : map.get(len)) {
            for (i = 0; i < len; i++) {
                if (word.charAt(i) == s.charAt(i) || word.charAt(i) == '.'){
                    continue;
                } else {
                    break;
                }
            }
            if (i == len) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

