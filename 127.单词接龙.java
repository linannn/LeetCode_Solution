/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        int len = 1;
        String now = "";
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");
        queue.offer(beginWord);
        while (queue.size() > 0) {
            now = queue.poll();
            if (now.length() == 0) {
                len += 1;
                queue.offer("");
                continue;
            }
            char[] arr = now.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char temp = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    if (temp == ch) {
                        continue;
                    }
                    String str = new String(arr);
                    if (str.equals(endWord))
                        return len;
                    if (words.contains(str) && !visited.contains(str)) {
                        queue.offer(str);
                    }
                }
                arr[i] = temp;
            }

        }


        return 0;
    }
}
// @lc code=end

