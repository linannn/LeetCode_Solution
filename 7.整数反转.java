/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
import java.util.LinkedList;
class Solution {
    public int reverse(int x) {
        boolean flag = x > 0 ? true : false;
        x = Math.abs(x);
        LinkedList<Integer> queue = new LinkedList<>();
        while (x > 0) {
            queue.offer(x % 10);
            x = x / 10;
        }
        long res = 0;
        while (queue.peek()!= null) {
            res = res * 10 + queue.poll();
        }
        if (!flag)
            res = -res;
        if (res >= Math.pow(-2, 31)  && res <= Math.pow(2, 31)-1)
            return (int) res;
        return 0;
    }
}
// @lc code=end

