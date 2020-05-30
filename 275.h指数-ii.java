/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        // int h = 1;
        // for (int i = len-1; i >= 0; i--) {
        //     if (citations[i] < h)
        //         break;
        //     h++;
        // }
        // return h-1;
        int idx = 0, n = citations.length;
        int pivot, left = 0, right = n - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (citations[pivot] == n - pivot) 
                return n - pivot;
            else if (citations[pivot] < n - pivot) 
                left = pivot + 1;
            else 
                right = pivot - 1;
        }
        return n - left;
    }
}
// @lc code=end

