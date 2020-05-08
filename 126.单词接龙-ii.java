/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> distSet = new HashSet<>(wordList);
        if (!distSet.contains(endWord)) {
            return res;
        }
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue= new LinkedList<>();
        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(list);
        visited.add(beginWord);
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String word = path.get(path.size() - 1);
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        if (temp == ch) {
                            continue;
                        }
                        String str = new String(chars);
                        if (distSet.contains(str) && !visited.contains(str)) {
                            List<String> pathList = new ArrayList<>(path);
                            pathList.add(str);
                            if (str.equals(endWord)) {
                                flag = true;
                                res.add(pathList);
                            }
                            queue.add(pathList);
                            subVisited.add(str);
                        }
                    }
                    chars[j] = temp;
                }
            }
            visited.addAll(subVisited);
        }
        return res;
    }

    private boolean similar(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean diff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (!diff) {
                    diff = true;
                } else {
                    return false;
                }
            }

        }
        return diff;
    }
}
// @lc code=end

