/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	private Integer cur = null;
	private Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (cur != null) {
			return cur;
		}
		cur = iterator.next();
		return cur;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
			if (cur != null) {
                int res = cur;
                cur = null;
                return res;
            }
            return iterator.next();
	    
	}
	
	@Override
	public boolean hasNext() {
	    return cur != null || iterator.hasNext();
	}
}
// @lc code=end

