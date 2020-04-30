/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<int[]> inter = new ArrayList<>();
//        inter.addAll(Arrays.asList(intervals));
        if (newInterval[0] >= intervals[intervals.length-1][1]) {
            inter.addAll(Arrays.asList(intervals));
            inter.add(newInterval);
        } else {
            inter.addAll(Arrays.asList(intervals));
            for (int i = 0; i < inter.size(); i++) {
                if (newInterval[0] > newInterval[1]) {
                    break;
                }

                if (inter.get(i)[0] >= newInterval[1]) {
                    inter.add(i, newInterval);
                    break;
                }
                // 左扩
                if (inter.get(i)[0] > newInterval[0] && inter.get(i)[0] <= newInterval[1]) {
                    int pre = i > 0? Math.max(newInterval[0], inter.get(i - 1)[1]) : newInterval[0];
                    inter.get(i)[0] = pre;
                    newInterval[0] = pre;
                }
                // 右扩
                if (inter.get(i)[1] < newInterval[1] && inter.get(i)[1] >= newInterval[0]) {
                    int next = i < inter.size()-1 ? Math.min(newInterval[1], inter.get(i + 1)[0]) : newInterval[1];
                    inter.get(i)[1] = next;
                    newInterval[0] = next;
                }
                if (inter.get(i)[1] > newInterval[1]) {
                    break;
                }
            }
        }
        List<int[]> handledRes = new ArrayList<>();
        for (int i = 0; i < inter.size(); i++) {
            int[] next = new int[2];
            next[0] = inter.get(i)[0];
            while (i < inter.size() - 1 && inter.get(i)[1] >= inter.get(i + 1)[0]) {
                i++;
            }
            next[1] = inter.get(i)[1];
            handledRes.add(next);
        }
        int[][] res = new int[handledRes.size()][2];
        for (int i = 0; i < handledRes.size(); i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = handledRes.get(i)[j];
            }
        }
        return res;
    }
}
// @lc code=end

