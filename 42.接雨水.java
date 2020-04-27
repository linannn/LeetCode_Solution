/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        // 按列
        // int res = 0;
        // for (int i = 1; i < height.length - 1; i++) {
        //     int h = height[i];
        //     int leftMax = 0;
        //     int rightMax = 0;
        //     for (int j = 0; j < i; j++) {
        //         leftMax = Math.max(leftMax, height[j]);
        //     }
        //     for (int j = i + 1; j < height.length; j++) {
        //         rightMax = Math.max(rightMax, height[j]);
        //     }
        //     leftMax = Math.min(leftMax, rightMax);
        //     if (leftMax > h) {
        //         res += leftMax - h;
        //     }
        // }
        // return res;
        
        // dp
        // int res = 0;
        // int[] leftMax = new int[height.length];
        // int[] rightMax = new int[height.length];
        // for (int i = 1; i < leftMax.length - 1; i++) {
        //     leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        // }
        // for (int i = rightMax.length - 2; i > 0; i--) {
        //     rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        // }
        // for (int i = 1; i < height.length - 1; i++) {
        //     int tmp = Math.min(rightMax[i], leftMax[i]);
        //     if (tmp > height[i])
        //         res += tmp - height[i];
        // }
        // return res;

        // 双指针
        // int res = 0;
        // int leftMax = 0;
        // int rightMax = 0;
        // int left = 1;
        // int right = height.length - 2;
        // for (int i = 1; i < height.length - 1; i++) {
        //     if (height[left - 1] < height[right + 1]) {
        //         leftMax = Math.max(leftMax, height[left - 1]);
        //         if (leftMax > height[left])
        //             res += leftMax - height[left];
        //         left++;
        //     } else {
        //         rightMax = Math.max(rightMax, height[right + 1]);
        //         if (rightMax > height[right])
        //             res += rightMax - height[right];
        //         right--;
        //     }
        // }
        // return res;

        // 单调栈
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break; 
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }
}
// @lc code=end

