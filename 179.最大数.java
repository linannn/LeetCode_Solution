/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    // private static class LargerNumberComparator implements Comparator<String> {
    //     @Override
    //     public int compare(String a, String b) {
    //         String order1 = a + b;
    //         String order2 = b + a;
    //         return order2.compareTo(order1);
    //     }
    // }

    // public String largestNumber(int[] nums) {
    //     String[] asStrs = new String[nums.length];
    //     for (int i = 0; i < nums.length; i++) {
    //         asStrs[i] = String.valueOf(nums[i]);
    //     }
    //     Arrays.sort(asStrs, new LargerNumberComparator());
    //     if (asStrs[0].equals("0")) {
    //         return "0";
    //     }
    //     StringBuilder largestNumberStr = new StringBuilder();
    //     for (String numAsStr : asStrs) {
    //         largestNumberStr.append(numAsStr);
    //     }
    //     return largestNumberStr.toString();
    // }
        public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = nums[i] + "";
        }
        for (int i = 0; i < numStrs.length; i++) {
            for (int j = i+1; j < numStrs.length; j++) {
                if (!compare(numStrs[i], numStrs[j])) {
                    String tmp = numStrs[i];
                    numStrs[i] = numStrs[j];
                    numStrs[j] = tmp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String s : numStrs) {
            builder.append(s);
        }
        return builder.toString();

    }
    private boolean compare (String s1, String s2) {
        boolean flag = false;
        if (s1.length() < s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
            flag = true;
        }
        int i = 0;
        for (;i < s2.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return !flag;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return flag;
            }
        }
        if (i < s1.length()) {
            if (s1.charAt(i - 1) < s1.charAt(i)) {
                return !flag;
            } else {
                return flag;
            }
        }
        return false;
    }
}
// @lc code=end

