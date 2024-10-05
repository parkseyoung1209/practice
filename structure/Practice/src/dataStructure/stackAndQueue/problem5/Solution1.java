package dataStructure.stackAndQueue.problem5;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
	
	private Deque<Integer> queue1 = new ArrayDeque<Integer>();
	private Deque<Integer> queue2 = new ArrayDeque<Integer>();
	// 1,2,3  삽입시
	public void push(int x) { // 3,2,1
		queue1.push(x);
	}
	
	public int pop() {
		peek(); // 1,2,3 queue2
		return queue2.pop();
	}
	public int peek() {
		if(queue2.isEmpty()) {
			while(!queue1.isEmpty()) {
				queue2.push(queue1.pop()); // 1,2,3
			}
		}
		return queue2.peek();
	}
	
	public boolean empty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
}
