/*
 * @lc app=leetcode.cn id=609 lang=java
 *
 * [609] 在系统中查找重复文件
 */

// @lc code=start
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        for (String str:paths) {
            String[] tmp = str.split(" ");
            String rootPath = tmp[0];
            for (int i = 1; i < tmp.length; i++) {
                String[] fileNameAndContent = tmp[i].split("\\(");
                String name = fileNameAndContent[0];
                String content = fileNameAndContent[1];
                if (!dict.containsKey(content))
                    dict.put(content, new ArrayList<>());
                dict.get(content).add(rootPath+"/"+name);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry:dict.entrySet()){
            if (entry.getValue().size() > 1)
                res.add(entry.getValue());
        }
        return res;
    }
}
// @lc code=end

