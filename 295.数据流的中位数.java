/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {

    }
    private PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int count = 0;

    public void addNum(int num) {
        count += 1;
        right.offer(num);
        left.offer(right.poll());
        if ((count & 1) == 0) {
            right.offer((left.poll()));
        }

    }

    public double findMedian() {
        if ((count & 1) == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

