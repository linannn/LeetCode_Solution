/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
import java.util.Stack;
class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);

    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack.empty()) {
            helper.push(stack.pop());
        }
        int res = helper.pop();
        while (!helper.empty()) {
            stack.push(helper.pop());
        }
        return res;

    }
    
    /** Get the front element. */
    public int peek() {
        int res = 0;
        while (!stack.empty()) {
            res = stack.pop();
            helper.push(res);
        }
        while (!helper.empty()) {
            stack.push(helper.pop());
        }
        return res;

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

