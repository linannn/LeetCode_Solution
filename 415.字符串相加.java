/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        int tmp, n1, n2;
        while (i >= 0 || j >= 0) {
            // n1 = i >= 0 ? Integer.parseInt(String.valueOf(num1.charAt(i))) : 0;
            n1 = i >= 0 ? num1.charAt(i)-48 : 0;
            // n2 = j >= 0 ? Integer.parseInt(String.valueOf(num2.charAt(j))) : 0;
            n2 = j >= 0 ? num2.charAt(j)-48 : 0;
            tmp = n1 + n2 + carry;
            carry = tmp / 10;
            sb.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1)
            sb.append(1);
        return sb.reverse().toString();

    }
}
// @lc code=end

