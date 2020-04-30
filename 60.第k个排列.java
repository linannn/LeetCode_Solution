/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        int jie = 1;
        for (int i = 1; i < n; i++) {
            jie *= i;
            fact[i] = jie;
        }
        fact[0] = 1;

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder b = new StringBuilder();
        k--;
        while (n > 0) {
            n--;
            int a = k / fact[n];
            k = k % fact[n];
            b.append(nums.get(a));
            nums.remove(a);
        }
        return b.toString();
    }
}
// @lc code=end

