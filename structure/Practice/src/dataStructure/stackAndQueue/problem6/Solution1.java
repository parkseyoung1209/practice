package dataStructure.stackAndQueue.problem6;

public class Solution1 {
	int[] q;
	int front = 0, rear = -1, len=0;
	
	public Solution1(int k) {
		this.q = new int[k];
	}
	
	public boolean enQueue(int value) {
		if(!this.isFull()) {
			this.rear = (this.rear +1) % (this.q.length);
			this.q[rear] = value;
			this.len++;
			return true;
		} else return false;
	}
	
	public boolean deQueue() {
		if(!this.isEmpty()) {
			this.front = (this.front +1) % this.q.length;
			this.len--;
			return true;
		} else return false;
	}
	
	public int front() {
		return (this.isEmpty() ? -1 : this.q[this.front]);
	}
	
	public int rear() {
		return (this.isEmpty() ? -1 : this.q[this.rear]);
	}
	
	public boolean isEmpty() {
		return this.len == 0;
	}
	
	public boolean isFull() {
		return this.len == this.q.length;
	}
}
