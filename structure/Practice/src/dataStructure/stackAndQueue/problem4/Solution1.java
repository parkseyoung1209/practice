package dataStructure.stackAndQueue.problem4;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
	
	Queue<Integer> myStack = new LinkedList<Integer>();
	
	public void push(int x) {
		myStack.add(x);
		
		for(int i=1; i<myStack.size(); i++) {
			myStack.add(myStack.remove());
		}
	}
	
	public int pop() {
		return myStack.remove();
	}
	
	public int top() {
		return myStack.peek();
	}
	
	public boolean empty() {
		return myStack.size() == 0;
	}
}
