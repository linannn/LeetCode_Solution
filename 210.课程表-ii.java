/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj= new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] line: prerequisites) {
            inDegree[line[0]]++;
            adj.get(line[1]).add(line[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res.add(pre);
            for(int cur : adj.get(pre)) {
                inDegree[cur]--;
                if (inDegree[cur] == 0) {
                    queue.offer(cur);
                }
            }
        }
        return res.size() == numCourses ? res.stream().mapToInt(Integer::valueOf).toArray() : new int[0];
    }
}
// @lc code=end

