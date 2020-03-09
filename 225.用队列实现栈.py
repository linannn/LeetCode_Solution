#
# @lc app=leetcode.cn id=225 lang=python3
#
# [225] 用队列实现栈
#

# @lc code=start
from collections import deque


class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.que = deque()

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        self.que.append(x)

    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        tmp = deque()
        while len(self.que) > 1:
            tmp.append(self.que.popleft())
        res = self.que.popleft()
        self.que = tmp
        return res

    def top(self) -> int:
        """
        Get the top element.
        """
        top = 0
        tmp = deque()
        while len(self.que) > 0:
            top = self.que.popleft()
            tmp.append(top)
        self.que = tmp
        return top

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return len(self.que) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
# @lc code=end
