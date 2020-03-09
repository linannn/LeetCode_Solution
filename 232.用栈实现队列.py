#
# @lc app=leetcode.cn id=232 lang=python3
#
# [232] 用栈实现队列
#

# @lc code=start


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        tmp = []
        while len(self.stack) > 1:
            tmp.append(self.stack.pop())
        res = self.stack.pop()
        while tmp:
            self.stack.append(tmp.pop())
        return res

    def peek(self) -> int:
        """
        Get the front element.
        """
        tmp = []
        peek = 0
        while self.stack:
            peek = self.stack.pop()
            tmp.append(peek)

        while tmp:
            self.stack.append(tmp.pop())
        return peek

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.stack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
# @lc code=end
