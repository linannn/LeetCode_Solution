/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.endsWith("e")) {
            return false;
        }
        if (s.indexOf('e') != s.lastIndexOf('e')) {
            return false;
        }
        String[] strs = s.split("e");
        if (strs.length == 1) {
            return isXiaoshu(strs[0]) != 0;
        }
        if (strs.length == 2) {
            int r1 = isXiaoshu(strs[0]);
            int r2 = isXiaoshu(strs[1]);
            return r1 != 0 && r2 != 0 && r2 != 2 && r2 != 4;
        }
        return false;
    }

    // 0不是 1是整数 2是小数
    private int isXiaoshu(String s) {
        if (s.indexOf('.') != s.lastIndexOf('.')) {
            return 0;
        }
        String[] strs = s.split("\\.");

        if (strs.length == 1) {
            return isZheng(strs[0]) == 0 ? 0 : 1;
        }
        if (strs.length == 2) {
            int zheng = isZheng(strs[0]);
            if (strs[0].length() == 0) {
                zheng = 1;
            }
            int xiao = isZheng(strs[1]);

            return zheng == 0 || xiao == 0 || xiao == 2 || xiao == 4? 0 : 1;
        }
        return 0;
    }
    // 0不是 1正 2负 4,带符号正
    private int isZheng(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int flag = 1;
        int i = 0;
        if (s.charAt(0) == '-') {
            flag = 2;
            i = 1;
        }
        if (s.charAt(0) == '+') {
            flag = 4;
            i = 1;
        }
        for (; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return 0;
            }
        }
        return flag;
    }
}
// @lc code=end

