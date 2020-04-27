/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    // public String multiply(String num1, String num2) {
    //     if (num1.equals("0") || num2.equals("0")) {
    //         return "0";
    //     }
    //     String res = "0";
    //     for (int i = 0; i < num2.length(); i++) {
    //         res = add(res, multiply(num1, num2.charAt(i) - '0', num2.length() - i - 1));
    //     }

    //     return res;
    // }
    // private String add(String num1, String num2) {
    //     if (num1.length() < num2.length()) {
    //         String tmp = num1;
    //         num1 = num2;
    //         num2 = tmp;
    //     }
    //     int carry = 0;
    //     StringBuilder builder = new StringBuilder();
    //     for (int i = 0; i < num1.length(); i++) {
    //         int n1 = num1.charAt(num1.length()-1-i) - '0';
    //         int n2 = i < num2.length() ? num2.charAt(num2.length()-1-i) - '0' : 0;
    //         int tmp = n1 + n2 + carry;
    //         builder.insert(0, tmp % 10);
    //         carry = tmp / 10;
    //     }
    //     if (carry != 0) {
    //         builder.insert(0, carry);
    //     }
    //     return builder.toString();
    // }
    // private String multiply(String num1, int num, int k) {
    //     StringBuilder builder = new StringBuilder();
    //     int carry = 0;
    //     for (int i = num1.length()-1; i >= 0; i--){
    //         int mulRes = (num1.charAt(i) - '0') * num + carry;
    //         builder.insert(0, mulRes % 10);
    //         carry = mulRes / 10;
    //     }
    //     if (carry != 0) {
    //         builder.insert(0, carry);
    //     }
    //     for (int i = 0; i < k; i++) {
    //         builder.append('0');
    //     }
    //     return builder.toString();
    // }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length()-1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length()-1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = res[i+j+1] + n1 * n2;
                res[i+j+1] = sum % 10;
                res[i+j] += sum / 10;
            }
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0)
                continue;
            b.append(res[i]);
        }
        return b.toString();
    }

}
// @lc code=end

