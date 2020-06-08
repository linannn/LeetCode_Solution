/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int[] box = new int[10];
        int A = 0;
        int B = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
                continue;
            }
            box[secret.charAt(i) - '0']++;
            box[guess.charAt(i) - '0']--;
        }
        for (int i = 0; i < 10; i++) {
            if (box[i] > 0)
                B += box[i];
        }
        B = secret.length() - B - A;
        return A + "A" + B + "B";
    }

}
// @lc code=end

