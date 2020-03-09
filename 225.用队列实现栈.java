/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
import java.util.LinkedList;
class MyStack {
    LinkedList<Integer> que = new LinkedList<>();
    LinkedList<Integer> helper = new LinkedList<>();

    
    /** Initialize your data structure here. */
    public MyStack() {

    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        que.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (que.size() > 1) {
            helper.offer(que.poll());
        }
        int res = que.poll();
        que = helper;
        helper = new LinkedList<>();
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        int top = 0;
        while (que.size() > 0) {
            top = que.poll();
            helper.offer(top);
        }
        que = helper;
        helper = new LinkedList<>();
        return top;

    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.size() == 0;

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

