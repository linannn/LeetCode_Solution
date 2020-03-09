/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
import java.util.Stack;
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] pathPart = path.split("/");
        for (String part: pathPart) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        for (String part : stack) {
            builder.append(part);
            builder.append("/");
        }
        if (!stack.empty())
            builder.deleteCharAt(builder.lastIndexOf("/"));
        return builder.toString();
    }
}
// @lc code=end

